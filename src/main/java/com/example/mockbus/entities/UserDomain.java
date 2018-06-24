package com.example.mockbus.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
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

import org.hibernate.annotations.NaturalId;

import com.example.mockbus.entities.audit.DateAudit;

@Entity
@Table(name = "users")
public class UserDomain extends DateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2531879678658457700L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@NaturalId
	private String email;

	private String password;

    @Column(name = "enabled")
	private boolean isEnabled=true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleDomain> roles = new HashSet<>();

	public Set<TicketDomain> getTickets() {
		return tickets;
	}

	public void setTickets(Set<TicketDomain> tickets) {
		this.tickets = tickets;
	}

	@OneToMany(mappedBy = "user")
	private Set<TicketDomain> tickets;

	public UserDomain() {

	}

	public UserDomain(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleDomain> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDomain> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object o) {
		if (this==o){
			return true;
		}
		if (o==null||this.getClass()!=o.getClass()){
			return false;
		}
		return this.hashCode()==o.hashCode();
	}
}