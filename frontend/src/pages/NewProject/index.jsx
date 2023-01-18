import {
  Container,
  Box,
  InputTitle,
  DivTitle,
  Title,
  InputBody,
  DivButton
} from "./styles";
import StandardButton from "../../components/StandardButton";

export default function NewProject() {
  return (
    <Container>
      <Box>
        <Title>Nome do Projeto</Title>
        <DivTitle>
          <InputTitle placeholder="Ex: Projeto de Python" />
        </DivTitle>
        <Title>Descrição do Projeto</Title>
        <DivTitle>
          <InputBody></InputBody>
        </DivTitle>
        <DivButton>
          <StandardButton text="Criar" />
        </DivButton>
      </Box>
    </Container>
  );
}
