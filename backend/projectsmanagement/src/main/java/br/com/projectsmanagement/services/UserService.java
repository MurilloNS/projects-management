package br.com.projectsmanagement.services;

import java.util.List;
import java.util.Optional;

import br.com.projectsmanagement.dto.UserDto;
import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.jwt.Token;

public interface UserService {
	public List<User> listUsers();

	public Optional<User> getUserById(Long id);

	public User registerUser(User user);

	public User updateUser(Long id, User user);

	public void deleteUser(Long id);

	public Boolean validatePass(User user);

	public Token gerarToken(UserDto user);
}