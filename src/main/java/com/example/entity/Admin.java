package com.example.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String password;

    
 // Constructors, getters, and setters
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String password) {
		super();
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
