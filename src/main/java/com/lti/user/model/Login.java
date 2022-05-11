package com.lti.user.model;

public class Login {

	
   @Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

private String username;
	
	private String password;
	
	private ERole role;

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
