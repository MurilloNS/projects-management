package br.com.projectsmanagement.services.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.exception.InvalidIdException;
import br.com.projectsmanagement.repositories.UserRepository;
import br.com.projectsmanagement.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public User registerUser(User user) {
		user.setDataCadastro(new Date());
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		try {
			User userUpdated = userRepository.findById(id).get();
			userUpdated.setName(user.getName());
			userUpdated.setEmail(user.getEmail());
			userUpdated.setPassword(user.getPassword());
			return userRepository.saveAndFlush(userUpdated);
		} catch (NoSuchElementException e) {
			throw new InvalidIdException("Usuário não encontrado!");
		}
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub

	}
}