package com.uol.host.service.interfaces;

import com.uol.host.entities.Codename;

import java.util.List;

public interface PersistAvengersCodenamesInterface {
  public static record Input(List<String> listOfCodenames) {}

  public static record Output(List<Codename> listOfCodenames) {}
}
