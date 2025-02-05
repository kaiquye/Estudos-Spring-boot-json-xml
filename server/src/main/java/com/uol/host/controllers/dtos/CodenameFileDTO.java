package com.uol.host.controllers.dtos;

import java.util.List;

public record CodenameFileDTO(List<Codename> vingadores) {
  public record Codename(String codinome) {}
}
