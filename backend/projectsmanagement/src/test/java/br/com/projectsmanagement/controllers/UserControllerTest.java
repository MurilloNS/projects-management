package br.com.projectsmanagement.controllers;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.services.impl.UserServiceImpl;

@SpringBootTest
class UserControllerTest {
	private User user;
	private Optional<User> optionalUser;

	@InjectMocks
	private UserController userController;

	@Mock
	private UserServiceImpl userServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void whenFindAllThenReturnAListofUsers() {
		when(userServiceImpl.listUsers()).thenReturn(List.of(user));

		ResponseEntity<List<User>> response = userController.listUsers();

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(User.class, response.getBody().get(0).getClass());
		assertEquals(user.getId(), response.getBody().get(0).getId());
	}

	@Test
	void whenFindByIdThenReturnSuccess() {
		when(userServiceImpl.getUserById(anyLong())).thenReturn(optionalUser);

		ResponseEntity<Optional<User>> response = userController.getUserById(1L);

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(optionalUser.getClass(), response.getBody().getClass());
		assertEquals(optionalUser.get().getId(), response.getBody().get().getId());
	}

	@Test
	void whenRegisterThenReturnCreated() {
		when(userServiceImpl.registerUser(any())).thenReturn(user);

		ResponseEntity<User> response = userController.registerUser(user);

		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
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