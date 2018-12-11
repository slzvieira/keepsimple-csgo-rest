/*
 * @(#)Start.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados. RGF
 * PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa;

import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.domain.Match;
import br.com.keepsimple.ffa.domain.Player;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * Classe de inicializacao da aplicacao. Tambem eh responsavel pela carga inicial de dados dos
 * arquivos JSON.
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@SpringBootApplication
@EnableFeignClients
public class Start extends SpringBootServletInitializer {

    /** Arquivo JSON contendo as partidas (matches). */
    private static final String MATCHES_RESOURCE = "/matches.json";

    /** Arquivo JSON contendo as disputas (kills). */
    private static final String WRANGLE_RESOURCE = "/wrangle.json";

    /** Arquivo JSON contendo os players e seus ceps. */
    private static final String PLAYERS_RESOURCE = "/players.json";

    /** Log da aplicacao (Commons Logging). */
    private static final Log log = LogFactory.getLog(Start.class);

    /**
     * Inicia o contexto Spring Boot como aplicacao embbed (Tomcat embutido).
     * 
     * @param args
     *        Argumentos de entrada (nao utilizado)
     */
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

    /**
     * Inicia o contexto Spring Boot como aplicacao web quando distribuida em servidor independente
     * (arquivo war).
     * 
     * @param application
     * @return
     * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(
     *      org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Start.class);
    }

    /**
     * Gera o command responsavel pela carga dos dados a partir dos arquivos JSON.
     * 
     * @param service
     * @return
     */
    @Bean
    CommandLineRunner runner(MatchService service) {

        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            /*
             * Realiza a carga do arquivos wrangle.json e matches.json
             */
            try (InputStreamReader wrangleStream = new InputStreamReader(Start.class.getResourceAsStream(WRANGLE_RESOURCE));
                            InputStreamReader matchesStream = new InputStreamReader(Start.class.getResourceAsStream(MATCHES_RESOURCE));
                            InputStreamReader playersStream = new InputStreamReader(Start.class.getResourceAsStream(PLAYERS_RESOURCE))) {

                List<Kill> killList = mapper.readValue(wrangleStream, new TypeReference<List<Kill>>() {});
                service.saveKills(killList);
                log.info(WRANGLE_RESOURCE + " carregado com sucesso.");

                List<Match> matchList = mapper.readValue(matchesStream, new TypeReference<List<Match>>() {});
                service.saveMatches(matchList);
                log.info(MATCHES_RESOURCE + " carregado com sucesso.");

                List<Player> playerList = mapper.readValue(playersStream, new TypeReference<List<Player>>() {});
                service.savePlayers(playerList);
                log.info(MATCHES_RESOURCE + " carregado com sucesso.");
            }
        };
    }
}
