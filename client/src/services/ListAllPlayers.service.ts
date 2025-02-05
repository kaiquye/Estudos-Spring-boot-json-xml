import api from "./api/default.api";
import { Player } from "./structures/player.structure";
import { IRequest } from "./structures/request.structure";

class ListAllPlayersService implements IRequest<Input, Output> {
  public async send(): Promise<Output> {
    const { data } = await api.get("/player");
    console.log(data);
    return data.data.players.map(player => {
      return {
        player_id: player.player_id,
        name: player.name,
        email: player.email,
        phone: player.phone,
        codename: player.codename,
        team: player.team,
      } as Player;
    });
  }
}

export default new ListAllPlayersService();

export type Input = null;
export type Output = Array<Player>;
