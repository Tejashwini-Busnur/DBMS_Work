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
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String label;

	@ManyToOne
	private Faculty author;

	public Course(String label) {
		this.label = label;
	}

	public Course() {

	}

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Section> sections = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Faculty getAuthor() {
		return author;
	}

	public void setAuthor(Faculty author) {
		this.author = author;

	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void assignSection(Section section) {
		this.sections.add(section);

	}

}
