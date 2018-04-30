/*
 * @(#)Start.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.domain.Match;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * TODO DOCUMENT ME
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@SpringBootApplication
public class Start {

    private static final String MATCHES_RESOURCE = "/matches.json";

    private static final String WRANGLE_RESOURCE = "/wrangle.json";

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Start.class, args);
    }

    @Bean
    CommandLineRunner runner(MatchService service) {

        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            /* Carrega o arquivo wrangle.json */
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Start.class.getResourceAsStream(WRANGLE_RESOURCE)))) {

                Kill kill;

                while (reader.ready()) {
                    kill = mapper.readValue(reader.readLine(), Kill.class);
                    service.saveKill(kill);
                }
            }

            System.out.println(WRANGLE_RESOURCE + " loaded with success");

            /* Carrega o arquivo matches.json */
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Start.class.getResourceAsStream(MATCHES_RESOURCE)))) {

                Match match;
                StringBuilder builder = null;;
                int count = 0;

                while (reader.ready()) {
                    if (++count % 2 == 1) {
                        builder = new StringBuilder(reader.readLine());
                    } else {
                        builder.append(reader.readLine());
                        match = mapper.readValue(builder.toString(), Match.class);
                        service.saveMatch(match);
                    }
                }
            }

            System.out.println(MATCHES_RESOURCE + " loaded with success");
        };
    }
}
