import {
  Container,
  ProjectsBox,
  TitleBox,
  DivTitleBox,
  ColorSituationBox,
  SituationBox,
  DivSituation,
  Separator,
  DeleteProject,
  DivButton,
  NavLink,
} from "./styles";

import StandardButton from "../../components/StandardButton";

export default function Project() {
  return (
    <Container>
      <DivButton>
        <NavLink to="/newproject">
          <StandardButton text="Criar Projeto" />
        </NavLink>
      </DivButton>
      <ProjectsBox>
        <DivTitleBox>
          <TitleBox>Projeto de Python</TitleBox>
          <DivSituation>
            <ColorSituationBox />
            <SituationBox>Em Andamento</SituationBox>
            <DeleteProject>Deletar Projeto</DeleteProject>
          </DivSituation>
        </DivTitleBox>
        <Separator />
        <p>
          hbhbsdhbdbhhhhhhhhhhhhhhhhhhhhhjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
        </p>
      </ProjectsBox>
    </Container>
  );
}
