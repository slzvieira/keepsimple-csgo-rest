package br.com.keepsimple.ffa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.keepsimple.ffa.domain.Player;

/**
 * @author alessandro
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
