package edu.northeastern.cs5200.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.jpa.models.Course;
import edu.northeastern.cs5200.jpa.models.Enrollment;
import edu.northeastern.cs5200.jpa.models.Faculty;
import edu.northeastern.cs5200.jpa.models.Person;
import edu.northeastern.cs5200.jpa.models.Section;
import edu.northeastern.cs5200.jpa.models.Student;
import edu.northeastern.cs5200.jpa.repository.*;

@Repository
public class UniversityDao {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private SectionRepository sectionRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	public void truncateDatabase() {
		enrollmentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		personRepository.deleteAll();

	}

	public Faculty createFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);

	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public Section createSection(Section section) {
		return sectionRepository.save(section);
	}

	public Section addSectionToCourse(Section section, Course course) {
		section.setCourse(course);
		return sectionRepository.save(section);
	}

	public Course setAuthorForCourse(Faculty faculty, Course course) {
		course.setAuthor(faculty);
		return courseRepository.save(course);
	}

	public Boolean enrollStudentInSection(Student student, Section section) {

		int numOfSeats = section.getSeats();
		if (numOfSeats == 0) {
			return false;
		} else if (numOfSeats > 0) {
			Enrollment enrollment = new Enrollment(student, section);
			student.addEnrollment(enrollment);
			section.addEnrollment(enrollment);
			section.setSeats(section.getSeats() - 1);
			enrollmentRepository.save(enrollment);
			sectionRepository.save(section);
			return true;
		}
		return false;
	}

	public List<Person> findAllUsers() {
		return (List<Person>) personRepository.findAll();
	}

	public List<Faculty> findAllFaculty() {
		return (List<Faculty>) facultyRepository.findAll();
	}

	public List<Student> findAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	public List<Course> findAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	public List<Section> findAllSections() {
		return (List<Section>) sectionRepository.findAll();
	}

	public List<Course> findCoursesForAuthor(Faculty faculty) {
		return faculty.getAuthoredCourses();
	}

	public List<Section> findSectionForCourse(Course course) {
		return course.getSections();
	}

	public List<Student> findStudentsInSection(Section section) {
		List<Student> students = new ArrayList<>();
		List<Enrollment> enrollments = section.getEnrollments();
		for (Enrollment enrollment : enrollments) {
			Student student = enrollment.getStudent();
			students.add(student);
		}
		return students;
	}

	public List<Section> findSectionsForStudent(Student student) {
		List<Section> sections = new ArrayList<>();
		List<Enrollment> enrollments = enrollmentRepository.findEnrollments(student.getId());
		for (Enrollment enrollment : enrollments) {
			Section section = enrollment.getSection();
			sections.add(section);
		}
		return sections;
	}

}
