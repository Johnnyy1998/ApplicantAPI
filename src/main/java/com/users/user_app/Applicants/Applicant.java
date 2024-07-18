package com.users.user_app.Applicants;

import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.user_app.Accounts.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Applicant {
	
	@OneToMany(mappedBy = "applicant")
	@JsonIgnore
	private List<Account> account;
	
	@Id
	private Integer id;
	@Size(min=2, message = "Name Should have at least 2 characters")
	private String name;
	@Size(min=1, message = "Name Should have at least 5 characters")
	private String email;
	
	public Applicant() {}
	
	public Applicant(Integer id, @Size(min = 2, message = "Name Should have at least 2 characters") String name,
			@Size(min = 1, message = "Name Should have at least 5 characters") String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	public List<Account> getAccount(){
		return account;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
	

}
