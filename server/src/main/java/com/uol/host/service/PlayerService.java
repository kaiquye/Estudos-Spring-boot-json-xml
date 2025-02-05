package com.uol.host.service;

import com.uol.host.service.interfaces.ListAllPlayersInterface;
import com.uol.host.service.interfaces.RegisterNewPlayerInterface;

public interface PlayerService {
    RegisterNewPlayerInterface.Output registerNewPlayer(RegisterNewPlayerInterface.Input input) throws Exception;
    ListAllPlayersInterface.Output listAllPlayers(Integer page, Integer size) throws Exception;
}
