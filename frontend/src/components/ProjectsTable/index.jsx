import {
  ProjectsBox,
  DivTitleBox,
  TitleBox,
  DivSituation,
  ColorSituationBox,
  SituationBox,
  DeleteProject,
  Separator,
} from "./styles";

export default function ProjectsTable({ list, finalizeMethod, deleteMethod }) {
  return (
    <>
      {list.map((project) => (
        <ProjectsBox key={project.id}>
          <DivTitleBox>
            <TitleBox>{project.name}</TitleBox>
            <DivSituation>
              <ColorSituationBox situation={project.finalDate} />
              <SituationBox situation={project.finalDate}>
                {project.finalDate ? "Concluído" : "Em Andamento"}
              </SituationBox>
              {!project.finalDate ? (
                <DeleteProject
                  type="submit"
                  onClick={() => finalizeMethod(project.id)}
                >
                  Finalizar Projeto
                </DeleteProject>
              ) : (
                <DeleteProject
                  type="submit"
                  onClick={() => deleteMethod(project.id)}
                >
                  Deletar Projeto
                </DeleteProject>
              )}
            </DivSituation>
          </DivTitleBox>
          <Separator />
          <p>{project.description}</p>
        </ProjectsBox>
      ))}

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
    </>
  );
}
