package com.uol.host.controllers;

import com.uol.host.common.ResponseBase;
import com.uol.host.common.enums.ETeam;
import com.uol.host.controllers.dtos.RegisterPlayerDTO;
import com.uol.host.service.PlayerService;
import com.uol.host.service.interfaces.ListAllPlayersInterface;
import com.uol.host.service.interfaces.RegisterNewPlayerInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/player")
public class PlayerController {
  private final PlayerService playerService;

  @PostMapping()
  private ResponseEntity<ResponseBase<RegisterNewPlayerInterface.Output>> register(
      @RequestBody RegisterPlayerDTO request) throws Exception {
    var input =
        new RegisterNewPlayerInterface.Input(
            request.name(), request.email(), request.phone(), ETeam.valueOf(request.typeOfTeam()));

    var output = this.playerService.registerNewPlayer(input);

    return ResponseEntity.ok(new ResponseBase<>(output));
  }

  @GetMapping()
  private ResponseEntity<ResponseBase<ListAllPlayersInterface.Output>> listAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
      throws Exception {
    var output = this.playerService.listAllPlayers(page, size);
    return ResponseEntity.ok(new ResponseBase<>(output));
  }
}
