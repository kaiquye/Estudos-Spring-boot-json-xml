package com.uol.host.service.impl;

import com.uol.host.common.enums.ETeam;
import com.uol.host.entities.Codename;
import com.uol.host.repositories.CodenameRepository;
import com.uol.host.repositories.TeamRepository;
import com.uol.host.service.CodenameService;
import com.uol.host.service.interfaces.PersistAvengersCodenamesInterface;
import com.uol.host.service.interfaces.PersistJusticeLeagueCodenamesInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodenameServiceImpl implements CodenameService {
  private final TeamRepository teamRepository;
  private final CodenameRepository codenameRepository;

  @Override
  public PersistAvengersCodenamesInterface.Output persistAvengersCodenames(
      PersistAvengersCodenamesInterface.Input input) throws Exception {
    var teamFound = this.teamRepository.findByName(ETeam.AVENGERS);
    if (teamFound.isEmpty()) {
      throw new Exception("Avengers team not exists");
    }

    var listOfCodenames =
        input.listOfCodenames().stream()
            .map(
                (newCodename) -> {
                  var codename = new Codename();
                  codename.setName(newCodename);
                  codename.setTeam(teamFound.get());
                  return codename;
                })
            .toList();

    return new PersistAvengersCodenamesInterface.Output(
        this.codenameRepository.saveAll(listOfCodenames));
  }

  @Override
  public PersistJusticeLeagueCodenamesInterface.Output persistJusticeLeagueCodenames(
      PersistJusticeLeagueCodenamesInterface.Input input) throws Exception {
    var teamFound = this.teamRepository.findByName(ETeam.JUSTICE_LEAGUE);
    if (teamFound.isEmpty()) {
      throw new Exception("Justice league not exists");
    }

    var listOfCodenames =
        input.codenames().stream()
            .map(
                (newCodename) -> {
                  var codename = new Codename();
                  codename.setName(newCodename);
                  codename.setTeam(teamFound.get());
                  return codename;
                })
            .toList();

    return new PersistJusticeLeagueCodenamesInterface.Output(
        this.codenameRepository.saveAll(listOfCodenames));
  }
}
