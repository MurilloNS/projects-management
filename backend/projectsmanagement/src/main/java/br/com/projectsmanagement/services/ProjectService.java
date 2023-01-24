package br.com.projectsmanagement.services;

import java.util.List;
import java.util.Optional;

import br.com.projectsmanagement.entities.Project;

public interface ProjectService {
	public Optional<Project> getProjectById(Long id);

	public Project updateProject(Long id, Project project);

	public void deleteProject(Long id);

	public List<Project> listProjectsByUser(Long userId);

	public Project assignProjectToUser(Long userId, Project project);

	public Project finalizeProjectUser(Long projectId);
}