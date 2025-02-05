package com.uol.host.service.interfaces;

import com.uol.host.entities.Codename;

import java.util.List;

public interface PersistJusticeLeagueCodenamesInterface {
  public static record Input(List<String> codenames) {}

  public static record Output(List<Codename> codenames) {}
}
