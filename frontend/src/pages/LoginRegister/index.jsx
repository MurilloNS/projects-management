import {
  Container,
  Box,
  BoxLogin,
  Title,
  Input,
  Forget,
  Button,
  Divisor,
  DivisorRegister
} from "./styles";

export default function LoginRegister() {
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
        <BoxLogin>
          <Title>Criar conta</Title>
          <Input type="text" placeholder="Insira seu nome" />
          <Input type="email" placeholder="Insira seu e-mail" />
          <Input type="password" placeholder="Insira sua senha" />
          <DivisorRegister />
          <Button type="submit">Enviar</Button>
        </BoxLogin>
      </Box>
    </Container>
  );
}
