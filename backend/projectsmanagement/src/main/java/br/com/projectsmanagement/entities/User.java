package br.com.projectsmanagement.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_users")
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Email
	private String email;
	private String password;
	private LocalDate dateRegister;
	@OneToMany
	@JoinColumn(name = "id_user")
	private List<Project> projects;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_paper", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "paper_id"))
	private Set<Paper> papers = new HashSet<>();

	public User() {
	}

	public User(String name, @Email String email, String password, LocalDate dateRegister, List<Project> projects,
			Set<Paper> papers) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dateRegister = dateRegister;
		this.projects = projects;
		this.papers = papers;
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

	public LocalDate getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(LocalDate dateRegister) {
		this.dateRegister = dateRegister;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public Set<Paper> getPapers() {
		return papers;
	}

	public void addProject(Project projects) {
		this.projects.add(projects);
	}

	public void removeProject(Project projects) {
		this.projects.remove(projects);
	}

	public void addPaper(Paper papers) {
		this.papers.add(papers);
	}

	public void removePaper(Paper papers) {
		this.papers.remove(papers);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return papers;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}