package br.com.projectsmanagement.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "tb_projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private LocalDate initialDate = LocalDate.now();
	private LocalDate finalDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private User user;

	public Project() {
	}

	public Project(String name, String description, LocalDate initialDate, LocalDate finalDate) {
		this.name = name;
		this.description = description;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public void addUser(User user) {
		this.user = user;
	}
}