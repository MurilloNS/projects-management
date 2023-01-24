package br.com.projectsmanagement.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import br.com.projectsmanagement.configurations.JwtUtil;
import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.services.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/listar")
	public ResponseEntity<List<User>> listUsers() {
		return ResponseEntity.ok(userService.listUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<User> getIdByEmail(@PathVariable String email) {
		return ResponseEntity.ok(userService.getUserByEmail(email));
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

	@PostMapping("/logar")
	public ResponseEntity<?> login(@RequestBody User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User result = (User) authentication.getPrincipal();
		String token = jwtUtil.tokenUsernameGenerate(result);
		HashMap<String, String> map = new HashMap<>();
		map.put("token", token);
		map.put("email", user.getEmail());
		return ResponseEntity.ok(map);
	}
}