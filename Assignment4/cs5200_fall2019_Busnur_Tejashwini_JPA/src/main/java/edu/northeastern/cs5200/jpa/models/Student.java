package edu.northeastern.cs5200.jpa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Student extends Person {

	private int gradYear;
	private long scholarship;

	public Student() {

	}

	public Student(int id, String username, String password, String firstname, String lastname, int gradYear,
			long scholarship) {
		super(id, username, password, firstname, lastname);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}

	public Student(String username, String password, String firstname, String lastname, int gradYear,
			long scholarship) {
		super(username, password, firstname, lastname);
		this.gradYear = gradYear;
		this.scholarship = scholarship;

	}

	public int getGradYear() {
		return gradYear;
	}

	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}

	public long getScholarship() {
		return scholarship;
	}

	public void setScholarship(long scholarship) {
		this.scholarship = scholarship;
	}

	@OneToMany(mappedBy = "student")
	private List<Enrollment> enrollments = new ArrayList<>();

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public void addEnrollment(Enrollment enrollment) {
		this.enrollments.add(enrollment);

	}

}
