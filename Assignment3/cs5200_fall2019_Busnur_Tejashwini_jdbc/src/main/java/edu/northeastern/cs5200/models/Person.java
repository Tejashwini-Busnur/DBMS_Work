package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public abstract class Person {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private Date dob;

	private Collection<Phone> phone_numbers = new ArrayList<>();
	private Collection<Address> addresses = new ArrayList<>();

	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			Collection<Phone> phones, Collection<Address> addresses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phone_numbers = phones;
		this.addresses = addresses;
	}

	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Collection<Phone> getPhone_numbers() {
		return phone_numbers;
	}

	public void setPhone_numbers(Collection<Phone> phone_numbers) {
		this.phone_numbers = phone_numbers;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

}
