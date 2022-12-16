package br.com.projectsmanagement.controllers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.services.UserService;
import io.restassured.http.ContentType;

@WebMvcTest
class UserControllerTest {
	@Autowired
	private UserController userController;

	@MockBean
	private UserService userService;

	private Optional<User> optionalUser;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.userController);
		startUser();
	}

	@Test
	public void whenGetUserByIdThenReturnAnUserInstance() {
		when(userService.getUserById(Mockito.anyLong())).thenReturn(optionalUser);

		given().accept(ContentType.JSON).when().get("/usuario/{id}", 1L).then().statusCode(HttpStatus.OK.value());
	}

	private void startUser() {
		optionalUser = Optional.of(new User("fernando", "fernando@gmail.com", "123", new Date()));
	}
}