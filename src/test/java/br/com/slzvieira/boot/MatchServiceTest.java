/*
 * @(#)MatchServiceTest.java 1.00 29/abr/2018
 *
 * Copyright 2018 RG Florencio Informatica LTDA. Todos os direitos reservados.
 * RGF PROPRIETARY/CONFIDENTIAL. Proibida a copia e-ou a reproducao deste codigo.
 */
package br.com.slzvieira.boot;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.keepsimple.ffa.domain.Kill;
import br.com.keepsimple.ffa.domain.Match;
import br.com.keepsimple.ffa.domain.Player;
import br.com.keepsimple.ffa.domain.Weapon;
import br.com.keepsimple.ffa.repository.KillRepository;
import br.com.keepsimple.ffa.repository.MatchRepository;
import br.com.keepsimple.ffa.service.MatchService;

/**
 * Teste unitario do servico {@link MatchService}
 * 
 * @author Sandro
 * @version 1.0, 29/abr/2018 - Implementation.
 */
public class MatchServiceTest {

    /** Mock do repositorio de matches. */
    @Mock
    private MatchRepository matchMockRepository;

    /** Mock do repositorio de kills. */
    @Mock
    private KillRepository killMockRepository;

    /** Servico a ser testado. */
    @InjectMocks
    private MatchService service;

    /**
     * Injeta os mocks.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Teste do metodo {@link MatchService#saveKill(Kill)}
     */
    @Test
    public void testSaveKill() {

        Kill kill = new Kill();

        kill.setId(1);
        kill.setMatch(100);
        kill.setKilltime(LocalTime.now());
        kill.setKiller("Eu");
        kill.setKilled("Ele");
        kill.setWeapon("Canivete de abrir garrafa");

        service.saveKill(kill);
    }

    /**
     * Teste do metodo {@link MatchService#saveMatch(Match)}
     */
    @Test
    public void testSaveMatch() {

        Match match = new Match();

        match.setMatch(666);
        /* 01/01/2018 00:00:00 */
        match.setBegin(ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault()));
        match.setEnd(ZonedDateTime.now());

        service.saveMatch(match);
    }

    /**
     * Teste do metodo {@link MatchService#findAllMatches()}.
     */
    @Test
    public void testFindAllMatches() {

        Match match = new Match();

        match.setMatch(666);
        /* 01/01/2018 00:00:00 */
        match.setBegin(ZonedDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault()));
        match.setEnd(ZonedDateTime.now());

        Mockito.when(matchMockRepository.findAll()).thenReturn(Arrays.asList(match));
        Collection<Match> list = service.findAllMatches();
        Assert.assertTrue(list != null && list.size() == 1);
    }

    /**
     * TODO IMPLEMENT ME
     */
    @Test
    public void testFindMatch() {
        Assert.fail("Not yet implemented");
    }

    /**
     * Teste do metodo {@link MatchService#findAllKills()}.
     */
    @Test
    public void testFindAllKills() {
        Mockito.when(killMockRepository.findAll()).thenReturn(getMockKillList());
        List<Kill> list = service.findAllKills();
        Assert.assertTrue(list != null && list.size() == 5);
    }

    /**
     * Teste do metodo {@link MatchService#findPlayersByPeriod(LocalTime, LocalTime)}.
     */
    @Test
    public void testFindPlayersByPeriod() {
        Mockito.when(killMockRepository.findByPeriod(Mockito.any(LocalTime.class), Mockito.any(LocalTime.class)))
            .thenReturn(new ArrayList<>());
        List<Player> list = service.findPlayersByPeriod(LocalTime.MIN, LocalTime.NOON);
        Assert.assertTrue(list.isEmpty());
    }

    /**
     * Teste do metodo {@link MatchService#findAllPlayers()}.
     * Verifica se a separacao de {@link Player}s esta correta a partir de uma lista de {@link Kill}.
     */
    @Test
    public void testFindAllPlayers() {
        Mockito.when(killMockRepository.findAll()).thenReturn(getMockKillList());
        List<Player> list = service.findAllPlayers();
        Assert.assertTrue(
            list != null && list.size() == 3 && list.get(0).getName().equals("Manuel") && list.get(0).getScore() == 2);
    }

    /**
     * Teste do metodo {@link MatchService#findWeaponsByPeriod(LocalTime, LocalTime)}.
     */
    @Test
    public void testFindWeaponsByPeriod() {
        Mockito.when(killMockRepository.findByPeriod(Mockito.any(LocalTime.class), Mockito.any(LocalTime.class)))
            .thenReturn(new ArrayList<>());
        List<Weapon> list = service.findWeaponsByPeriod(LocalTime.MIN, LocalTime.NOON);
        Assert.assertTrue(list.isEmpty());
    }

    /**
     * Teste do metodo {@link MatchService#findAllWeapons()}.
     * Verifica se a separacao de {@link Weapon}s esta correta a partir de uma lista de {@link Kill}.
     */
    @Test
    public void testFindAllWeapons() {
        Mockito.when(killMockRepository.findAll()).thenReturn(getMockKillList());
        List<Weapon> list = service.findAllWeapons();
        Assert.assertTrue(
            list != null && list.size() == 4 && list.get(0).getName().equals("Canivete") && list.get(0).getKill() == 2);
    }

    /**
     * Pequena lista mock de kills.
     * @return Lista mock para testes.
     */
    private List<Kill> getMockKillList() {

        List<Kill> mockList = new ArrayList<>();
        Kill kill;

        kill = new Kill();
        kill.setId(1);
        kill.setMatch(100);
        kill.setKilltime(LocalTime.now());
        kill.setKiller("Manuel");
        kill.setKilled("Joaquim");
        kill.setWeapon("Canivete");
        mockList.add(kill);

        kill = new Kill();
        kill.setId(2);
        kill.setMatch(100);
        kill.setKilltime(LocalTime.now());
        kill.setKiller("Manuel");
        kill.setKilled("Maria");
        kill.setWeapon("Canivete");
        mockList.add(kill);

        kill = new Kill();
        kill.setId(3);
        kill.setMatch(100);
        kill.setKilltime(LocalTime.now());
        kill.setKiller("Joaquim");
        kill.setKilled("Manuel");
        kill.setWeapon("Pedrada");
        mockList.add(kill);

        kill = new Kill();
        kill.setId(4);
        kill.setMatch(100);
        kill.setKilltime(LocalTime.now());
        kill.setKiller("Maria");
        kill.setKilled("Joaquim");
        kill.setWeapon("Vassourada");
        mockList.add(kill);

        kill = new Kill();
        kill.setId(5);
        kill.setMatch(100);
        kill.setKilltime(LocalTime.now());
        kill.setKiller("Manuel");
        kill.setKilled("Maria");
        kill.setWeapon("Soco");
        mockList.add(kill);

        return mockList;
    }
}
