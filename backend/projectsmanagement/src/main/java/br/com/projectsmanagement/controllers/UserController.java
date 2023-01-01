package br.com.projectsmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectsmanagement.entities.Project;
import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.services.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/listar")
	public ResponseEntity<List<User>> listUsers() {
		return ResponseEntity.ok(userService.listUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/addproject")
	public ResponseEntity<User> assignProjectToUser(@PathVariable Long id, @RequestBody Project project) {
		return ResponseEntity.ok(userService.assignProjectToUser(id, project));
	}

	@PutMapping("/{userId}/removeproject/{projectId}")
	public ResponseEntity<User> removeProjectUser(@PathVariable Long userId, @PathVariable Long projectId) {
		return ResponseEntity.ok(userService.finalizeProjectUser(userId, projectId));
	}
}