package com.example.mockbus.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.mockbus.annotations.PasswordMatches;
import com.example.mockbus.annotations.UniqueEmail;
import org.hibernate.annotations.NaturalId;

import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.TicketDomain;
import org.hibernate.validator.constraints.UniqueElements;

@PasswordMatches
public class UserDTO {

	@NotBlank
	@Size(max = 40)
	private String name;

	@NotBlank
	@Email
	@UniqueEmail
	private String email;

	@NotBlank
	@Size(max = 100,min = 8)
	private String password;
	@NotBlank
	@Size(max = 100,min = 8)
	private String retypedPassword;


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


	public String getRetypedPassword() {
		return retypedPassword;
	}

	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}
}
