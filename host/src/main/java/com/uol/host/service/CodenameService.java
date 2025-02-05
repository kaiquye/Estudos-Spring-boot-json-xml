package com.uol.host.service;

import com.uol.host.service.interfaces.PersistAvengersCodenamesInterface;
import com.uol.host.service.interfaces.PersistJusticeLeagueCodenamesInterface;

public interface CodenameService {
  PersistAvengersCodenamesInterface.Output persistAvengersCodenames(
      PersistAvengersCodenamesInterface.Input input) throws Exception;

  PersistJusticeLeagueCodenamesInterface.Output persistJusticeLeagueCodenames(
          PersistJusticeLeagueCodenamesInterface.Input input) throws Exception;
}
