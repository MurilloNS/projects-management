package br.com.projectsmanagement.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalDate;

	public Project() {
	}

	public Project(String name, String description, Date initialDate, Date finalDate) {
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

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
}