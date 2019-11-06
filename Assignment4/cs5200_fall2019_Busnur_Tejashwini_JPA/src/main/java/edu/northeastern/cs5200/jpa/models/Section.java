package edu.northeastern.cs5200.jpa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seats;
	private String title;

	@ManyToOne()
	private Course course;

	@OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
	private List<Enrollment> enrollments = new ArrayList<>();

	public Section() {

	}

	public Section(int id, int seats) {
		super();
		this.id = id;
		this.seats = seats;
	}

	public Section(String title, int seats, Course course) {
		super();
		this.seats = seats;
		this.title = title;
		this.course = course;
	}

	public Section(String title, int seats) {
		this.seats = seats;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

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
