package br.com.projectsmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectsmanagement.entities.User;
import br.com.projectsmanagement.services.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<User>> listUsers(){
		return ResponseEntity.ok(userService.listUsers());
	}
}