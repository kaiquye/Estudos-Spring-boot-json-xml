package com.uol.host.repositories;

import com.uol.host.entities.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);

    @EntityGraph(attributePaths = {"codename", "codename.team"})
    Page<Player> findAll(Pageable pageable);
}
