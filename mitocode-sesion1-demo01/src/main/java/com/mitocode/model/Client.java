package com.mitocode.model;

public class Client {

	private String name;
	private String email;
	
	public Client() {
		
	}
	
	public Client(String name, String email) {	
		this.name=name;
		this.email=email;
	}
	
	public Client(String name) {
		this.name=name;		
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
	
	@Override
	public String toString() {
		return this.name+"-"+this.email;
	}

}
