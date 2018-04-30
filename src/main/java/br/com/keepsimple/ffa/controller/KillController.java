/*
 * @(#)KillController.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.keepsimple.ffa.controller;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * Expoe o microservico REST para a entidade {@link Kill}
 * 
 * @author Sandro Vieira
 * @version 1.0, 29/abr/2018 - Implementation.
 */
@RestController
public class KillController {

    /** Log da aplicacao (Commons logging). */
    private static final Log log = LogFactory.getLog(KillController.class);

    /** Servico responsavel por obter os dados a serem expostos. */
    @Autowired
    private MatchService service;

    /**
     * Prove a lista completa de todos os kills registrados no sistema.
     * Embora este metodo nao tenha sido solicitado, o mesmo foi necessario
     * para depuracao e conferencia de resultados.
     * 
     * @return Lista de todos os kills registrados.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/kills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Kill>> getAllKills() {
        log.debug("KillController#getAllKills() - Inicio");
        List<Kill> killList = service.findAllKills();
        log.debug("KillController#getAllKills() - Fim");
        return new ResponseEntity<>(killList, HttpStatus.OK);
    }

    /**
     * Metodo inclusao de {@link Kill}. Permite o cadastro REST de uma morte no sistema.
     * @param kill contendo o matador, morto, arma utilizada e id da partida.
     * @return Status de inclusao.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/kills", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Kill> postKill(@RequestBody Kill kill) {

        if (log.isDebugEnabled()) {
            log.debug("KillController#postKill() - Inicio - "
                    + ToStringBuilder.reflectionToString(kill, ToStringStyle.JSON_STYLE));
        }

        service.saveKill(kill);

        log.debug("KillController#postKill() - Fim");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
