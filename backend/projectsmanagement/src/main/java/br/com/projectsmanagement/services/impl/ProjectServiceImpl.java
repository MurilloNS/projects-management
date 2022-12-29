package br.com.projectsmanagement.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectsmanagement.entities.Project;
import br.com.projectsmanagement.exception.InvalidIdException;
import br.com.projectsmanagement.exception.NotFinalizedException;
import br.com.projectsmanagement.repositories.ProjectRepository;
import br.com.projectsmanagement.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Project> listAll() {
		return projectRepository.findAll();
	}

	@Override
	public Optional<Project> getProjectById(Long id) {
		return projectRepository.findById(id);
	}

	@Override
	public Project registerProject(Project project) {
		return projectRepository.saveAndFlush(project);
	}

	@Override
	public Project updateProject(Long id, Project project) {
		try {
			Project projectUpdated = projectRepository.findById(id).get();
			projectUpdated.setName(project.getName());
			projectUpdated.setDescription(project.getDescription());
			return projectRepository.saveAndFlush(projectUpdated);
		} catch (NoSuchElementException e) {
			throw new InvalidIdException("Projeto não encontrado!");
		}
	}

	@Override
	public void deleteProject(Long id) {
		Project project = projectRepository.findById(id).get();
		if (project.getFinalDate() != null) {
			projectRepository.deleteById(id);
		} else {
			throw new NotFinalizedException("Você não pode deletar um projeto antes de finalizá-lo");
		}
	}
}