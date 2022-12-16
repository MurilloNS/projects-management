package br.com.projectsmanagement.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projectsmanagement.entities.User;
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
		assertEquals(user.getName(), "Valdir");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	private void startUser() {
		user = new User("Valdir", "valdir@gmail.com", "123456", new Date());
		optionalUser = Optional.of(new User("Valdir", "valdir@gmail.com", "123456", new Date()));
	}
}