package br.com.projectsmanagement.services;

import java.util.List;
import java.util.Optional;

import br.com.projectsmanagement.entities.Project;

public interface ProjectService {
	public List<Project> listAll();

	public Optional<Project> getProjectById(Long id);

	public Project registerProject(Project project);

	public Project updateProject(Long id, Project project);

	public void deleteProject(Long id);
}