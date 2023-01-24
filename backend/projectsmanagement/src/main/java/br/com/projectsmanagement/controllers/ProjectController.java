package br.com.projectsmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projectsmanagement.entities.Project;
import br.com.projectsmanagement.services.ProjectService;

@RestController
@RequestMapping("/projeto")
@CrossOrigin("http://localhost:3000")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/listar/{userId}")
	public ResponseEntity<List<Project>> listProjectsByUser(@PathVariable Long userId) {
		return ResponseEntity.ok(projectService.listProjectsByUser(userId));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Project>> getProjectById(@PathVariable Long id) {
		return ResponseEntity.ok(projectService.getProjectById(id));
	}
	
	@PostMapping("/{userId}/addproject")
	public ResponseEntity<Project> assignProjectToUser(@PathVariable Long userId, @RequestBody Project project) {
		return ResponseEntity.ok(projectService.assignProjectToUser(userId, project));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
		return ResponseEntity.ok(projectService.updateProject(id, project));
	}
	
	@PutMapping("/finalizeproject/{projectId}")
	public ResponseEntity<Project> removeProjectUser(@PathVariable Long projectId) {
		return ResponseEntity.ok(projectService.finalizeProjectUser(projectId));
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
		return ResponseEntity.noContent().build();
	}
}