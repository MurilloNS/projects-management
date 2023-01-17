package br.com.projectsmanagement.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.exception.EmailExistException;
import br.com.projectsmanagement.exception.InvalidIdException;
import br.com.projectsmanagement.repositories.UserRepository;

@SpringBootTest
class UserServiceImplTest {
	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepository userRepository;

	private User user;
	private Optional<User> optionalUser;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void whenFindAllThenReturnAnListofUsers() {
		when(userRepository.findAll()).thenReturn(List.of(user));

		List<User> response = userServiceImpl.listUsers();

		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(User.class, response.get(0).getClass());
	}

	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		when(userRepository.findById(anyLong())).thenReturn(optionalUser);

		Optional<User> response = userServiceImpl.getUserById(1L);

		assertThat(response).isPresent();
		assertEquals(optionalUser.getClass(), response.getClass());
		assertEquals(optionalUser.get().getName(), "Valdir");
	}

	@Test
	void whenRegisterThenReturnSuccess() {
		when(userRepository.saveAndFlush(any())).thenReturn(user);

		User response = userServiceImpl.registerUser(user);

		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(user.getId(), response.getId());
	}

	@Test
	void whenRegisterThenReturnAnEmailExistException() {
		when(userRepository.findByEmail(anyString())).thenReturn(user);

		try {
			userServiceImpl.registerUser(user);
		} catch (ClassCastException e) {
			assertEquals(EmailExistException.class, e.getClass());
			assertEquals("Esse e-mail já está cadastrado!", e.getMessage());
		}

		User response = userServiceImpl.registerUser(user);

		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(user.getId(), response.getId());
	}

	@Test
	void whenUpdateThenReturnSuccess() {
		when(userRepository.findById(anyLong())).thenReturn(optionalUser);

		userServiceImpl.updateUser(1L, user);

		verify(userRepository, times(1)).saveAndFlush(any());
	}

	@Test
	void whenDeleteThenReturnSuccess() {
		when(userRepository.findById(anyLong())).thenReturn(optionalUser);
		doNothing().when(userRepository).deleteById(anyLong());

		userServiceImpl.deleteUser(1L);

		verify(userRepository, times(1)).deleteById(anyLong());
	}

	@Test
	void whenDeleteThenReturnInvalidIdException() {
		when(userRepository.findById(anyLong())).thenThrow(new NoSuchElementException());
		try {
			userServiceImpl.deleteUser(1L);
		} catch (NoSuchElementException e) {
			assertEquals(InvalidIdException.class, e.getClass());
			assertEquals("Esse usuário já não existe!", e.getMessage());
		}
	}

	private void startUser() {
		user = new User("Valdir", "valdir@gmail.com", "123456", LocalDate.now(), null, null);
		optionalUser = Optional.of(new User("Valdir", "valdir@gmail.com", "123456", LocalDate.now(), null, null));
	}
}