package br.com.projectsmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.services.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/listar")
	public ResponseEntity<List<User>> listUsers() {
		return ResponseEntity.ok(userService.listUsers());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
}