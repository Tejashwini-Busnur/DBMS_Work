package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.util.Date;

public class Developer extends Person {

	private String developerKey;

	public Developer(int id, String firstName, String lastName, String username, String password, String email,
			Date dob, Collection<Phone> phones, Collection<Address> addresses, String developerKey) {
		super(id, firstName, lastName, username, password, email, dob, phones, addresses);
		// TODO Auto-generated constructor stub
		this.setDeveloperKey(developerKey);
	}

	public Developer(int id, String firstName, String lastName, String username, String password, String email,
			Date dob, String developerKey) {
		super(id, firstName, lastName, username, password, email, dob);
		// TODO Auto-generated constructor stub
		this.setDeveloperKey(developerKey);
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	

}
