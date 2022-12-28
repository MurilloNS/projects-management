package br.com.projectsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectsmanagement.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}