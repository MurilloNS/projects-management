package br.com.projectsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projectsmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}