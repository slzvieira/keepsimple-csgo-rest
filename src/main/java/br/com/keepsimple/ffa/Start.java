/*
 * @(#)Start.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * Classe de inicializacao da aplicacao. Tambem eh
 * responsavel pela carga inicial de dados dos arquivos JSON.
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@SpringBootApplication
public class Start {

    /** Arquivo JSON contendo as partidas (matches). */
    private static final String MATCHES_RESOURCE = "/matches.json";

    /** Arquivo JSON contendo as disputas (kills). */
    private static final String WRANGLE_RESOURCE = "/wrangle.json";

    /** Log da aplicacao (Commons Logging). */
    private static final Log log = LogFactory.getLog(Start.class);
    
    /**
     * Inicia o contexto Spring Boot e toda a aplicacao.
     * @param args Argumentos de entrada (nao utilizado)
     */
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

    /**
     * Gera o command responsavel pela carga dos dados a partir dos arquivos JSON.
     * @param service
     * @return
     */
    @Bean
    CommandLineRunner runner(MatchService service) {

        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            /*
             * Realiza a carga do arquivo wrangle.json
             * efetuando o parse de um kill por linha de texto
             */
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Start.class.getResourceAsStream(WRANGLE_RESOURCE)))) {

                Kill kill;

                while (reader.ready()) {
                    kill = mapper.readValue(reader.readLine(), Kill.class);
                    service.saveKill(kill);
                }
            }

            log.info(WRANGLE_RESOURCE + " carregado com sucesso.");

            /*
             * Realiza a carga do arquivo matches.json
             * efetuando o parse de um match a cada duas linhas de texto
             */
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

            log.info(MATCHES_RESOURCE + " carregado com sucesso.");
        };
    }
}
