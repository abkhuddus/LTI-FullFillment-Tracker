package com.lti.user.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="User" )
public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username="  + ", lastname=" + lastname + ", password=" + password
				+ ", firstname=" + firstname + ", email=" + email + "]";
	}


	private String id;
	
	
	private String lastname;
	
	private String defaultPassword;
	
	@Indexed(unique=true)
	private String psNumber;
	
	@Indexed(unique=true)
  private String pin;
	
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPsNumber() {
		return psNumber;
	}

	public void setPsNumber(String psNumber) {
		this.psNumber = psNumber;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	public String getLastname() {
		return lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	private String password;
	
	private String firstname;
	private String email;
	
	
private ERole role;
	

	public ERole getRole() {
	return role;
}

public void setRole(ERole role) {
	this.role = role;
}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	

	

	public String getPassword() {
		return password;
	}	

	public void setPassword(String password) {
		this.password = password;
	}
}
