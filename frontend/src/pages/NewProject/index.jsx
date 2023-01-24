import { useState } from "react";
import {
  Container,
  Box,
  InputTitle,
  DivTitle,
  Title,
  InputBody,
  DivButton,
} from "./styles";
import StandardButton from "../../components/StandardButton";
import http from "../../apis/http";
import Swal from "sweetalert2";

export default function NewProject() {
  const [project, setProject] = useState({ name: "", description: "" });
  const userEmail = localStorage.getItem("email");

  const handleChange = (e) => {
    setProject({ ...project, [e.target.name]: e.target.value });
  };

  const findIdByEmail = (e) => {
    e.preventDefault();

    http
      .get(`/usuario/email/${userEmail}`)
      .then((response) => {
        localStorage.setItem("id", response.data.id);
        saveProject();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const saveProject = () => {
    http
      .post(`/projeto/${localStorage.getItem("id")}/addproject`, project)
      .then((response) => {
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Projeto criado!",
          showConfirmButton: false,
          timer: 1500,
        });
        setProject({ name: "", description: "" });
      })
      .catch((err) => {
        console.log(err.response.data);
      });
  };

  return (
    <Container>
      <Box onSubmit={findIdByEmail}>
        <Title>Nome do Projeto</Title>
        <DivTitle>
          <InputTitle
            onChange={handleChange}
            value={project.name}
            name="name"
            type="text"
            placeholder="Ex: Projeto de Python"
          />
        </DivTitle>
        <Title>Descrição do Projeto</Title>
        <DivTitle>
          <InputBody
            onChange={handleChange}
            value={project.description}
            name="description"
            type="text"
          ></InputBody>
        </DivTitle>
        <DivButton>
          <StandardButton text="Criar" type="submit" />
        </DivButton>
      </Box>
    </Container>
  );
}
