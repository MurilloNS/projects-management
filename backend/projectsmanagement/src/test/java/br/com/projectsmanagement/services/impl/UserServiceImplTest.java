package br.com.projectsmanagement.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	void testListUsers() {
		fail("Not yet implemented");
	}

	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(optionalUser);
		
		Optional<User> response = userServiceImpl.getUserById(1L);
		
		assertThat(response).isPresent();
		assertEquals(user, response.get());
		assertEquals(user.getName(), "Valdir");
	}

	@Test
	void testRegisterUser() {
		fail("Not yet implemented");
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