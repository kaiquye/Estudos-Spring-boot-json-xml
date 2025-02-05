import React from "react";
import { Player } from "../../services/structures/player.structure";
import ListAllPlayersService from "../../services/ListAllPlayers.service";

export function PlayerList() {
  const [playerList, setPlayerList] = React.useState<Array<Player>>([]);

  const findAllPlayers = async () => {
    const response = await ListAllPlayersService.send();
    setPlayerList(response);
  };

  React.useEffect(() => {
    const fetchData = async () => {
      await findAllPlayers();
    };

    fetchData();
  }, []);

  return (
    <div className="flex flex-col justify-center items-center h-dvh">
      <div className="p-7 border border-black w-[700px] h-[500px] overflow-x-auto">
        <div className="pb-5 text-2xl">
          <p>Jogadores cadastrados.</p>
        </div>
        <div className="w-full overflow-x-auto">
          <table className="w-full border-collapse border border-gray-300">
            <thead>
              <tr className="bg-gray-200 text-left text-gray-700">
                <th className="p-2 border border-gray-300">Nome</th>
                <th className="p-2 border border-gray-300">E-mail</th>
                <th className="p-2 border border-gray-300">Telefone</th>
                <th className="p-2 border border-gray-300">Nickname</th>
                <th className="p-2 border border-gray-300">Grupo</th>
                <th className="p-2 border border-gray-300">Ação</th>
              </tr>
            </thead>
            <tbody>
              {playerList &&
                playerList.map(player => (
                  <tr className="odd:bg-white even:bg-gray-100">
                    <td className="p-2 border border-gray-300">{player.name}</td>
                    <td className="p-2 border border-gray-300">{player.email}</td>
                    <td className="p-2 border border-gray-300">{player.phone}</td>
                    <td className="p-2 border border-gray-300">{player.codename}</td>
                    <td className="p-2 border border-gray-300">{player.team}</td>
                    <td className="p-2 border border-gray-300 flex gap-2">
                      <button className="px-3 py-1 bg-blue-500 text-white rounded hover:bg-blue-600">
                        Editar
                      </button>
                      <button className="px-3 py-1 bg-red-500 text-white rounded hover:bg-red-600">
                        Excluir
                      </button>
                    </td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
