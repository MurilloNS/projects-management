package br.com.projectsmanagement.entities;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_papers")
public class Paper implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public Paper() {
	}

	public Paper(String name) {
		this.name = name;
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

	@Override
	public String getAuthority() {
		return name;
	}
}