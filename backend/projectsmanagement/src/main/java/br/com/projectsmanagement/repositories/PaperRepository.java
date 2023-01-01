package br.com.projectsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectsmanagement.entities.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long> {
}