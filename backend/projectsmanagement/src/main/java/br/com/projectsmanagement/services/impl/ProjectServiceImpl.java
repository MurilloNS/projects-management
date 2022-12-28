package br.com.projectsmanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectsmanagement.repositories.ProjectRepository;
import br.com.projectsmanagement.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
}