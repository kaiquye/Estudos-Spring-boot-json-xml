package com.uol.host.repositories;

import com.uol.host.common.enums.ETeam;
import com.uol.host.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(ETeam name);
}
