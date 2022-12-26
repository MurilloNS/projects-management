package br.com.projectsmanagement.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegister;

	public User() {
	}

	public User(String name, String email, String password, Date dateRegister) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dateRegister = dateRegister;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}
}