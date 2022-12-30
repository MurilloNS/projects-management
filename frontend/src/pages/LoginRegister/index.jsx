import { useState } from "react";
import {
  Container,
  Box,
  BoxLogin,
  Title,
  Input,
  Forget,
  Button,
  Divisor,
  DivisorRegister,
} from "./styles";
import http from "../../apis/http";
import Swal from "sweetalert2";

export default function LoginRegister() {
  const [user, setUser] = useState({ name: "", email: "", password: "" });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    http.post("/usuario/cadastrar", user).then((result) => {
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Usuário cadastrado",
        showConfirmButton: false,
        timer: 1500,
      });
    }).catch((e) => {
      Swal.fire({
        icon: 'error',
        text: e.response.data.message,
      })
    });
  };

  return (
    <Container>
      <Box>
        <BoxLogin>
          <Title>Login</Title>
          <Input type="email" placeholder="Insira seu e-mail" />
          <Input type="password" placeholder="Insira sua senha" />
          <Forget>Esqueceu sua senha?</Forget>
          <Button type="submit">Logar</Button>
        </BoxLogin>
        <Divisor />
        <BoxLogin onSubmit={handleSubmit}>
          <Title>Criar conta</Title>
          <Input
            onChange={handleChange}
            value={user.name}
            name="name"
            type="text"
            placeholder="Insira seu nome"
          />
          <Input
            onChange={handleChange}
            value={user.email}
            name="email"
            type="email"
            placeholder="Insira seu e-mail"
          />
          <Input
            onChange={handleChange}
            value={user.password}
            name="password"
            type="password"
            placeholder="Insira sua senha"
          />
          <DivisorRegister />
          <Button type="submit">Enviar</Button>
        </BoxLogin>
      </Box>
    </Container>
  );
}
