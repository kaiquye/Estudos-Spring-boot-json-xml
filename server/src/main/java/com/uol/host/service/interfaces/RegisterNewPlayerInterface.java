package com.uol.host.service.interfaces;

import com.uol.host.common.enums.ETeam;

public interface RegisterNewPlayerInterface {
  static record Input(String name, String email, String phone, ETeam team) {}

  static record Output(Long userId) {}
}
