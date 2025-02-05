import { ETeam } from "../common/team.enum";
import api from "./api/default.api";
import { IRequest } from "./structures/request.structure";

class RegisterNewPlayerRequest implements IRequest<Input, Output | undefined> {
  public async send(input: Input): Promise<Output | undefined> {
    const response = await api.post("/player", input);
    console.log(response.data);
    return undefined;
  }
}

export default new RegisterNewPlayerRequest();

type Input = {
  name: string;
  email: string;
  phone: string;
  typeOfTeam: ETeam;
};

type Output = {
  id: string;
  name: string;
  email: string;
  phone: string;
  team: ETeam;
};
