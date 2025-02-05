package com.uol.host.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uol.host.common.enums.ETeam;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "team")
@Entity
@EqualsAndHashCode
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long team_id;

  @Enumerated(EnumType.STRING)
  private ETeam name;

  @CreatedDate private LocalDateTime createdAt;

  @LastModifiedDate private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "team")
  @JsonIgnore
  private Set<Codename> codenames;
}
