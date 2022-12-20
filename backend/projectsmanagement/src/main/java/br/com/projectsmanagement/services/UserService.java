package br.com.projectsmanagement.services;

import java.util.List;
import java.util.Optional;

import br.com.projectsmanagement.entities.User;

public interface UserService {
	public List<User> listUsers();

	public Optional<User> getUserById(Long id);

	public User registerUser(User user);

	public User updateUser(Long id, User user);

	public void deleteUser(Long id);
}