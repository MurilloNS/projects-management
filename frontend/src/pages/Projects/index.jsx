import { Container, DivButton, NavLink } from "./styles";

import StandardButton from "../../components/StandardButton";
import ProjectsTable from "../../components/ProjectsTable";
import { useEffect, useState } from "react";
import http from "../../apis/http";
import Swal from "sweetalert2";

export default function Project() {
  const userEmail = localStorage.getItem("email");
  const [projects, setProjects] = useState([]);
  const userId = localStorage.getItem("id");

  useEffect(() => {
    http
      .get(`/usuario/email/${userEmail}`)
      .then((response) => {
        localStorage.setItem("id", response.data.id);
      })
      .catch((err) => {
        console.log(err);
      });
  });

  useEffect(() => {
    http
      .get(`/projeto/listar/${userId}`)
      .then((result) => {
        setProjects(result.data);
      })
      .catch((err) => {
        console.log(err.data);
      });
  }, [userId]);

  const finalizeProject = (id) => {
    http
      .put("/projeto/finalizeproject/" + id)
      .then((response) => {
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Projeto finalizado, recarregue a página!",
          showConfirmButton: true,
        });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const deleteProject = (id) => {
    http
      .delete("/projeto/excluir/" + id + `/${userId}`)
      .then((response) => {
        if (response.status === 204) {
          window.location.reload();
        }
        console.log(response.status);
      })
      .catch((err) => {
        console.log(err.response);
      });
  };

  return (
    <Container>
      <DivButton>
        <NavLink to="/newproject">
          <StandardButton text="Criar Projeto" />
        </NavLink>
      </DivButton>
      <ProjectsTable
        list={projects}
        finalizeMethod={finalizeProject}
        deleteMethod={deleteProject}
      />
    </Container>
  );
}
