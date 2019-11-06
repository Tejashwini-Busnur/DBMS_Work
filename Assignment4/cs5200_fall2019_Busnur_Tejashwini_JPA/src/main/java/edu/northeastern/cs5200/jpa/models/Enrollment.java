package edu.northeastern.cs5200.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int grade;
	private String feedback;

	@ManyToOne()
	private Student student;

	@ManyToOne()
	private Section section;

	public Enrollment() {

	}

	public Enrollment(int id, int grade, String feedback) {
		super();
		this.id = id;
		this.grade = grade;
		this.feedback = feedback;
	}

	public Enrollment(Student student, Section section) {
		super();
		this.student = student;
		this.section = section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;

	}

}
