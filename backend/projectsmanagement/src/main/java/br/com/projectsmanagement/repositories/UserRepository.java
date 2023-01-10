package br.com.projectsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projectsmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	
	@Query("SELECT email FROM User WHERE email = :email")
	User findUserByEmail(String email);
}