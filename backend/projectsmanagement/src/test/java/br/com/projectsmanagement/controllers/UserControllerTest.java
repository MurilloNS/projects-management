package br.com.projectsmanagement.controllers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

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

	@BeforeEach
	public void setup() {
		standaloneSetup(this.userController);
	}

	@Test
	public void shallReturnSuccess_WhenSearchUser() {
		Mockito.<Optional<User>>when(this.userService.getUserById(1L))
				.thenReturn(Optional.of(new User("fernando", "fernando@gmail.com", "123", new Date())));
		given().accept(ContentType.JSON).when().get("/usuario/{id}", 4L).then().statusCode(HttpStatus.OK.value());
	}
}