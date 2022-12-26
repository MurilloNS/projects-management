import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";

import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Projects from "./pages/Projects";
import NewProject from "./pages/NewProject";
import LoginRegister from "./pages/LoginRegister";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/projects" element={<Projects />} />
        <Route path="/newproject" element={<NewProject />} />
        <Route path="/login" element={<LoginRegister />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
