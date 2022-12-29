package br.com.projectsmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projectsmanagement.entities.Project;
import br.com.projectsmanagement.services.ProjectService;

@RestController
@RequestMapping("/projeto")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@GetMapping("/listar")
	public ResponseEntity<List<Project>> listAll() {
		return ResponseEntity.ok(projectService.listAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Project>> getProjectById(@PathVariable Long id) {
		return ResponseEntity.ok(projectService.getProjectById(id));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Project> registerProject(@RequestBody Project project) {
		return new ResponseEntity<>(projectService.registerProject(project), HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
		return ResponseEntity.ok(projectService.updateProject(id, project));
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
		return ResponseEntity.noContent().build();
	}
}