import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import { Home } from "./pages/home/home";
import { PlayerList } from "./pages/playerList/playerList";
import "./index.css";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/home" />} />
        <Route path="/home" element={<Home />} />
        <Route path="/players" element={<PlayerList />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
