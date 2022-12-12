package br.com.projectsmanagement.services;

import java.util.List;

import br.com.projectsmanagement.entities.User;

public interface UserService {
	public List<User> listUsers();
	
	public User registerUser(User user);
	
	public User updateUser(Long id, User user);
	
	public void deleteUser(Long id);
}