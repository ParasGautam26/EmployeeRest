package com.nagarro.dto;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class LoginUser {
	@Id
	private String username;
	private String password;
	private int phone;

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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
