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
} from "./styles";

export default function Project() {
  return (
    <Container>
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
