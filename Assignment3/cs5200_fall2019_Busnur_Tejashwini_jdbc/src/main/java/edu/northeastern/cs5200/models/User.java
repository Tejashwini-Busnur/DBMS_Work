package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.util.Date;

public class User extends Person {
	
	private Boolean userAgreement;

	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			Collection<Phone> phones, Collection<Address> addresses) {
		super(id, firstName, lastName, username, password, email, dob, phones, addresses);
		// TODO Auto-generated constructor stub
		this.userAgreement = false;
	}
	
	public User(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		// TODO Auto-generated constructor stub
		this.userAgreement = false;
	}	

	public Boolean getUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(Boolean userAgreement) {
		this.userAgreement = userAgreement;
	}

}
