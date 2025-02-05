package com.uol.host.repositories;

import com.uol.host.common.enums.ETeam;
import com.uol.host.entities.Codename;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodenameRepository  extends JpaRepository<Codename, Long> {
    @Query(
            "SELECT c FROM Codename c " +
                    "LEFT JOIN c.team t ON t.name = :team " +
                    "LEFT JOIN c.player p ON p.codename IS NULL " +
                    "WHERE p IS NULL"
    )
    List<Codename> findCodenameByTeamName(ETeam team);
}
