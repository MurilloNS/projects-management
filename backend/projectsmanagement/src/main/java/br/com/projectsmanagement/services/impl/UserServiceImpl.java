package br.com.projectsmanagement.services.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.projectsmanagement.entities.Paper;
import br.com.projectsmanagement.entities.Project;
import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.exception.EmailExistException;
import br.com.projectsmanagement.exception.InvalidIdException;
import br.com.projectsmanagement.repositories.PaperRepository;
import br.com.projectsmanagement.repositories.ProjectRepository;
import br.com.projectsmanagement.repositories.UserRepository;
import br.com.projectsmanagement.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private PaperRepository paperRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

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
		Paper paper = paperRepository.findById(1L).get();
		try {
			if (userRepository.findUserByEmail(user.getEmail()) == null) {
				user.setDateRegister(new Date());
				user.addPaper(paper);
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				return userRepository.save(user);
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
			user.setPassword(passwordEncoder.encode(user.getPassword()));
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

	@Override
	public User assignProjectToUser(Long id, Project project) {
		User user = userRepository.findById(id).get();
		Project projectCreated = projectRepository.saveAndFlush(project);
		user.addProject(projectCreated);
		return userRepository.save(user);
	}

	@Override
	public User finalizeProjectUser(Long userId, Long projectId) {
		User user = userRepository.findById(userId).get();
		Project project = projectRepository.findById(projectId).get();
		project.setFinalDate(new Date());
		return userRepository.save(user);
	}
}