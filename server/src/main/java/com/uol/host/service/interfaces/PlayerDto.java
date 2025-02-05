package com.uol.host.service.interfaces;

import com.uol.host.common.enums.ETeam;
import com.uol.host.entities.Codename;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerDto {
    private Long player_id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String codename;
    private String team;
}
