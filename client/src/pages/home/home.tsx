import { useForm } from "react-hook-form";
import * as yup from "yup";
import { ETeam } from "../../common/team.enum";
import { yupResolver } from "@hookform/resolvers/yup";
import registerNewPlayerService from "../../services/registerNewPlayer.service";
import { useNavigate } from "react-router-dom";

export type IForm = {
  name: string;
  email: string;
  phone: string;
  team: "AVENGERS" | "JUSTICE_LEAGUE";
};

const schema = yup.object({
  name: yup.string().required("O nome é obrigatório"),
  email: yup.string().email("Email inválido").required("O email é obrigatório"),
  phone: yup.string().required("Telefone inválido"),
  team: yup.string().required("O time é obrigatório"),
});

export function Home() {
  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm({
    resolver: yupResolver(schema),
  });

  const handlerRegisterPlayer = async data => {
    const team = data.team as "AVENGERS" | "JUSTICE_LEAGUE";
    await registerNewPlayerService.send({
      name: data.name,
      email: data.email,
      phone: data.phone,
      typeOfTeam: ETeam[team],
    });
    reset();
  };

  const handlePlayersList = () => {
    return navigate("/players");
  };

  return (
    <section className="flex justify-center items-center bg-gray-400 h-dvh">
      <div className="flex-col p-5 w-1/5 bg-red-900">
        <h1 className="pb-5 font-bold">Cadastro de jogador UOL</h1>
        <form onSubmit={handleSubmit(handlerRegisterPlayer)}>
          <div className="grid grid-cols-4 pb-3">
            <label className="col-span-1">Name: </label>
            <input
              {...register("name")}
              className="p-2 col-span-3 w-full"
              type="text"
              placeholder="Enter your name"
            />
            <p>{errors.name?.message}</p>
          </div>
          <div className="grid grid-cols-4 pb-3">
            <label className="col-span-1">E-mail: </label>
            <input
              {...register("email")}
              className="p-2 col-span-3 w-full"
              type="text"
              placeholder="Enter your email"
            />
            <p>{errors.email?.message}</p>
          </div>
          <div className="grid grid-cols-4 pb-3">
            <label className="col-span-1">Telefone: </label>
            <input
              {...register("phone")}
              className="p-2 col-span-3 w-full"
              type="text"
              placeholder="Enter your telefone"
            />
            <p>{errors.email?.message}</p>
          </div>
          <div className="pt-3">
            <label className="font-bold">Quero ser do grupo:</label>
            <div>
              <div>
                <label>Vingadores:</label>
                <input {...register("team")} type="radio" value="JUSTICE_LEAGUE" />
              </div>
              <div>
                <label>Liga da justiça:</label>
                <input {...register("team")} type="radio" value="AVENGERS" />
              </div>
              <p>{errors.team?.message}</p>
            </div>
          </div>
          <div className="grid grid-cols-2 gap-2 pt-7 pb-3">
            <button className="col-span-1" type="submit">
              Cadastrar
            </button>
            <button onClick={handlePlayersList} className="col-span-1" type="button">
              Listar Jogadores
            </button>
          </div>
        </form>
      </div>
    </section>
  );
}
