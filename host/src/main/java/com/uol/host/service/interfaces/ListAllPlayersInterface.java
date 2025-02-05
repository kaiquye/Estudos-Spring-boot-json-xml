package com.uol.host.service.interfaces;

import java.util.List;


public interface ListAllPlayersInterface {
  static record Output(List<PlayerDto> players) {}
}
