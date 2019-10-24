package edu.northeastern.cs5200.models;

public class Phone {

	private String phone;
	private Boolean isPrimary;

	private int person;
	
	

	public Phone(String phone, Boolean isPrimary, int person) {
		super();
		this.phone = phone;
		this.isPrimary = isPrimary;
		this.person = person;
	}

	public boolean isPrimary() {
		return isPrimary;
	}
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

}
