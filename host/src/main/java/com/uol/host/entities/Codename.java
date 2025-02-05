package com.uol.host.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "codename")
public class Codename {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codename_id;

  @Column(nullable = false)
  private String name;

  @CreatedDate
  @CreationTimestamp
  private LocalDateTime createdAt;

  @LastModifiedDate private LocalDateTime updatedAt;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "player_id", referencedColumnName = "player_id")
  @JsonIgnore
  private Player player;  

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id", referencedColumnName = "team_id")
  private Team team;
}
