package edu.northeastern.cs5200.jpa.models;

import javax.persistence.*;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public Person(int id, String username, String password, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
	}

	public Person(String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstname;
		this.lastName = lastname;
	}

	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

}
