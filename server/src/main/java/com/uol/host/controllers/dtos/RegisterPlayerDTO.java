package com.uol.host.controllers.dtos;

import jakarta.validation.constraints.Pattern;

public record RegisterPlayerDTO(
    String name,
    String email,
    String phone,
    @Pattern(regexp = "^(Os Vingadores|A Liga da Justiça)$")
        String typeOfTeam) {}
