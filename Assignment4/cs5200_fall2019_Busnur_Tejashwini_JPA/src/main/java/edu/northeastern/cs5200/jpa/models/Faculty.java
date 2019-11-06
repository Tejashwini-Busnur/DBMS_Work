package edu.northeastern.cs5200.jpa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person {

	private String office;
	private boolean tenured;

	public Faculty(int id, String username, String password, String firstname, String lastname) {
		super(id, username, password, firstname, lastname);
		// TODO Auto-generated constructor stub
	}

	public Faculty(String username, String password, String firstname, String lastname, String office,
			boolean tenured) {
		super(username, password, firstname, lastname);
		this.office = office;
		this.tenured = tenured;
	}

	public Faculty() {
	}

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private List<Course> authoredCourses = new ArrayList<>();

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public boolean isTenured() {
		return tenured;
	}

	public void setTenured(boolean tenured) {
		this.tenured = tenured;
	}

	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}

	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}

	public void authoredCourse(Course course) {
		this.authoredCourses.add(course);

	}
}
