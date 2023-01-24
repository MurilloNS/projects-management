package br.com.projectsmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projectsmanagement.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	@Query("SELECT p FROM Project p WHERE p.user.id = :id")
	List<Project> findProjectByUser(Long id);
}