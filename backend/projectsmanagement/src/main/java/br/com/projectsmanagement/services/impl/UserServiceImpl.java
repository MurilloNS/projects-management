package br.com.projectsmanagement.services.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.exception.EmailExistException;
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
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User registerUser(User user) {
		try {
			if (findUserByEmail(user) == null) {
				user.setDataCadastro(new Date());
				return userRepository.saveAndFlush(user);
			}

			return user;
		} catch (ClassCastException e) {
			throw new EmailExistException("Esse e-mail já está cadastrado!");
		}
	}

	@Override
	public User updateUser(Long id, User user) {
		try {
			User userUpdated = userRepository.findById(id).get();
			userUpdated.setName(user.getName());
			userUpdated.setPassword(user.getPassword());
			return userRepository.saveAndFlush(userUpdated);
		} catch (NoSuchElementException e) {
			throw new InvalidIdException("Usuário não encontrado!");
		}
	}

	@Override
	public void deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new InvalidIdException("Esse usuário já não existe!");
		}
	}

	private User findUserByEmail(User user) {
		User userEmail = userRepository.findByEmail(user.getEmail());
		if (userEmail != null) {
			return userEmail;
		}

		return null;
	}
}