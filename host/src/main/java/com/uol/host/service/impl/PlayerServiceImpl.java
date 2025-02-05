package com.uol.host.service.impl;

import com.uol.host.entities.Codename;
import com.uol.host.entities.Player;
import com.uol.host.entities.Team;
import com.uol.host.repositories.CodenameRepository;
import com.uol.host.repositories.PlayerRepository;
import com.uol.host.service.PlayerService;
import com.uol.host.service.interfaces.ListAllPlayersInterface;
import com.uol.host.service.interfaces.PlayerDto;
import com.uol.host.service.interfaces.RegisterNewPlayerInterface;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class PlayerServiceImpl implements PlayerService {
  private final PlayerRepository playerRepository;
  private final CodenameRepository codenameRepository;

  @Override
  public RegisterNewPlayerInterface.Output registerNewPlayer(RegisterNewPlayerInterface.Input input)
      throws Exception {
    Optional<Player> playerAlreadyExists = this.playerRepository.findByEmail(input.email());
    if (playerAlreadyExists.isPresent()) {
      throw new Exception("Player already exists");
    }

    List<Codename> codenameOptional = this.codenameRepository.findCodenameByTeamName(input.team());
    if (codenameOptional.isEmpty()) {
      throw new Exception("No available codename found for the specified team: " + input.team());
    }

    var codename = codenameOptional.stream().findFirst().get();

    Player newPlayer = new Player();
    newPlayer.setName(input.name());
    newPlayer.setEmail(input.email());
    newPlayer.setPhone(input.phone());
    newPlayer.setCodename(codename);

    codename.setPlayer(newPlayer);
    Player player = this.playerRepository.save(newPlayer);
    this.codenameRepository.save(codename);

    return new RegisterNewPlayerInterface.Output(player.getPlayer_id());
  }

  @Override
  public ListAllPlayersInterface.Output listAllPlayers(Integer page, Integer size)
      throws Exception {
    Pageable pageable = PageRequest.of(page, size);
    var playersList = this.playerRepository.findAll(pageable);

    var response =
        playersList.getContent().stream()
            .map(
                (player -> {
                  return new PlayerDto(
                      player.getPlayer_id(),
                      player.getName(),
                      player.getEmail(),
                      player.getPhone(),
                      player.getCreatedAt(),
                      player.getUpdatedAt(),
                      player.getCodename().getName(),
                      player.getCodename().getTeam().getName().toString());
                }))
            .toList();
    return new ListAllPlayersInterface.Output(response);
  }
}
