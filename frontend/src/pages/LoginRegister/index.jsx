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
  Span,
  Alert,
} from "./styles";
import http from "../../apis/http";
import Swal from "sweetalert2";
import { useNavigate } from "react-router-dom";

export default function LoginRegister() {
  const [user, setUser] = useState({ name: "", email: "", password: "" });
  const [login, setLogin] = useState({ email: "", password: "" });
  const [emptyValue, setEmptyValue] = useState(false);
  const [errorLogin, setErrorLogin] = useState("");
  const emptyValues = Object.values(user).some((obj) => obj === "");
  const navigate = useNavigate();
  const refresh = () => window.location.reload(true);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleLoginChange = (e) => {
    setLogin({ ...login, [e.target.name]: e.target.value });
  };

  const inputValidations = () => {
    setEmptyValue(emptyValues);
  };

  const signIn = (e) => {
    e.preventDefault();

    http
      .post("/usuario/logar", login)
      .then((result) => {
        localStorage.setItem("email", result.data.email);
        autenticado(localStorage.setItem("token", result.data.token));
      })
      .catch((e) => {
        setErrorLogin(e.response.data.message);
      });
  };

  const autenticado = () => {
    if (localStorage.getItem("token")) {
      navigate("/");
      refresh();
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    inputValidations();

    if (!emptyValues) {
      http
        .post("/usuario/cadastrar", user)
        .then((result) => {
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Usuário cadastrado",
            showConfirmButton: false,
            timer: 1500,
          });
        })
        .catch((e) => {
          Swal.fire({
            icon: "error",
            text: e.response.data.message,
          });
        });
    }
  };

  return (
    <Container>
      <Box>
        <BoxLogin onSubmit={signIn}>
          <Title>Login</Title>
          {errorLogin !== "" ? <Alert>{errorLogin}</Alert> : ""}
          <Input
            onChange={handleLoginChange}
            value={login.email}
            name="email"
            type="email"
            placeholder="Insira seu e-mail"
          />
          <Input
            onChange={handleLoginChange}
            value={login.password}
            name="password"
            type="password"
            placeholder="Insira sua senha"
          />
          <Forget>Esqueceu sua senha?</Forget>
          <Button type="submit">Logar</Button>
        </BoxLogin>
        <Divisor />
        <BoxLogin onSubmit={handleSubmit}>
          <Title>Criar conta</Title>
          {emptyValue && user["name"] === "" ? (
            <Span>O campo nome precisa ser preenchido!</Span>
          ) : (
            ""
          )}
          <Input
            onChange={handleChange}
            value={user.name}
            name="name"
            type="text"
            placeholder="Insira seu nome"
          />
          {emptyValue && user["email"] === "" ? (
            <Span>O campo e-mail precisa ser preenchido!</Span>
          ) : (
            ""
          )}
          <Input
            onChange={handleChange}
            value={user.email}
            name="email"
            type="email"
            placeholder="Insira seu e-mail"
          />
          {emptyValue && user["password"] === "" ? (
            <Span>O campo senha precisa ser preenchido!</Span>
          ) : (
            ""
          )}
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
