package edu.northeastern.cs5200;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.Cs5200Fall2019BusnurTejashwiniJpaApplicationTests;
import edu.northeastern.cs5200.jpa.dao.UniversityDao;
import edu.northeastern.cs5200.jpa.models.Course;
import edu.northeastern.cs5200.jpa.models.Faculty;
import edu.northeastern.cs5200.jpa.models.Person;
import edu.northeastern.cs5200.jpa.models.Section;
import edu.northeastern.cs5200.jpa.models.Student;
import edu.northeastern.cs5200.jpa.repository.CourseRepository;
import edu.northeastern.cs5200.jpa.repository.EnrollmentRepository;
import edu.northeastern.cs5200.jpa.repository.FacultyRepository;
import edu.northeastern.cs5200.jpa.repository.PersonRepository;
import edu.northeastern.cs5200.jpa.repository.SectionRepository;
import edu.northeastern.cs5200.jpa.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUniversityDao extends Cs5200Fall2019BusnurTejashwiniJpaApplicationTests {

	@Autowired
	UniversityDao dao;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	FacultyRepository facultyRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Before
	public void setUp() {
		dao.truncateDatabase();
		testCreateFaculty();
		testCreateStudent();
		testCreateCourse();
		testCreateSection();
		testEnrollStudentInSection();
	}

	public void testCreateFaculty() {
		Faculty alan = new Faculty("alan", "Alan", "Alan", "Turin", "123A", true);
		Faculty ada = new Faculty("ada", "Ada", "Ada", "Lovelace", "123B", true);
		dao.createFaculty(alan);
		dao.createFaculty(ada);
	}

	public void testCreateStudent() {
		Student alice = new Student("alice", "Alice", "Alice", "Wonderland", 2020, 12000);
		Student bob = new Student("bob", "Bob", "Bob", "Hope", 2021, 23000);
		Student charlie = new Student("charlie", "Charlie", "Charlie", "Brown", 2019, 21000);
		Student dan = new Student("dan", "Dan", "Dan", "Craig", 2019, 0);
		Student edward = new Student("edward", "Edward", "Edward", "Scissorhands", 2022, 11000);
		Student frank = new Student("frank", "Fran", "Fran", "Herbert", 2018, 0);
		Student gregory = new Student("gregory", "Gregory", "Gregory", "Peck", 2023, 10000);

		dao.createStudent(alice);
		dao.createStudent(bob);
		dao.createStudent(charlie);
		dao.createStudent(dan);
		dao.createStudent(edward);
		dao.createStudent(frank);
		dao.createStudent(gregory);
	}

	public void testCreateCourse() {
		Faculty alan = facultyRepository.findFacultyByFirstName("Alan");
		Course course1 = new Course("CS1234");
		Course course2 = new Course("CS2345");
		// test set author for course
		dao.setAuthorForCourse(alan, course1);
		dao.setAuthorForCourse(alan, course2);
		Faculty ada = facultyRepository.findFacultyByFirstName("Ada");
		Course course3 = new Course("CS3456");
		Course course4 = new Course("CS4567");
		dao.setAuthorForCourse(ada, course3);
		dao.setAuthorForCourse(ada, course4);
		dao.createCourse(course1);
		dao.createCourse(course2);
		dao.createCourse(course3);
		dao.createCourse(course4);

	}

	public void testCreateSection() {
		{
			Course course1 = courseRepository.findCourseByLabel("CS1234");
			Course course2 = courseRepository.findCourseByLabel("CS2345");
			Course course3 = courseRepository.findCourseByLabel("CS3456");
			Section sec1 = new Section("SEC4321", 50, course1);
			Section sec2 = new Section("SEC5432", 50, course1);
			Section sec3 = new Section("SEC6543", 50, course2);
			Section sec4 = new Section("SEC7654", 50, course3);
			// test add section to course
			dao.addSectionToCourse(sec1, course1);
			dao.addSectionToCourse(sec2, course1);
			dao.createSection(sec3);
			dao.createSection(sec4);
		}

	}

	public void testEnrollStudentInSection() {
		Section sec1 = sectionRepository.findSectionByTitle("SEC4321");
		Section sec2 = sectionRepository.findSectionByTitle("SEC5432");
		Section sec3 = sectionRepository.findSectionByTitle("SEC6543");
		Student alice = studentRepository.findStudentByFirstName("Alice");
		Student bob = studentRepository.findStudentByFirstName("Bob");
		Student charlie = studentRepository.findStudentByFirstName("Charlie");
		alice.setEnrollments(new ArrayList<>());
		bob.setEnrollments(new ArrayList<>());
		charlie.setEnrollments(new ArrayList<>());
		dao.enrollStudentInSection(alice, sec1);
		dao.enrollStudentInSection(alice, sec2);
		dao.enrollStudentInSection(bob, sec2);
		dao.enrollStudentInSection(charlie, sec3);
	}

	@Test
	public void testFindAllUsers() {
		List<Person> list = dao.findAllUsers();
		for (Person person : list) {
			System.out.println(person.getFirstname());
		}
	}

	// Validate data

	@Test
	public void validateUsers() {
		List<Person> personList = dao.findAllUsers();
		assertEquals(9, personList.size());
	}

	@Test
	public void validateFaculty() {
		List<Faculty> facultyList = dao.findAllFaculty();
		assertEquals(2, facultyList.size());
	}

	@Test
	public void validateStudents() {
		List<Student> studentList = dao.findAllStudents();
		assertEquals(7, studentList.size());
	}

	@Test
	public void validateCourses() {
		List<Course> courseList = dao.findAllCourses();
		assertEquals(4, courseList.size());
	}

	@Test
	public void validateSections() {
		List<Section> sectionList = dao.findAllSections();
		assertEquals(4, sectionList.size());
	}

	@Test
	public void validateCourseAuthorhip() {
		Faculty alan = facultyRepository.findFacultyByFirstName("Alan");
		Faculty ada = facultyRepository.findFacultyByFirstName("Ada");
		List<Course> course1 = dao.findCourseForAuthor(alan);
		List<Course> course2 = dao.findCourseForAuthor(ada);
		assertEquals(2, course1.size());
		assertEquals(2, course2.size());
	}

	@Test
	public void validateSectionPerCourse() {
		Course course1 = courseRepository.findCourseByLabel("CS1234");
		Course course2 = courseRepository.findCourseByLabel("CS2345");
		Course course3 = courseRepository.findCourseByLabel("CS3456");
		Course course4 = courseRepository.findCourseByLabel("CS4567");
		List<Section> secForCourse1 = dao.findSectionForCourse(course1);
		List<Section> secForCourse2 = dao.findSectionForCourse(course2);
		List<Section> secForCourse3 = dao.findSectionForCourse(course3);
		List<Section> secForCourse4 = dao.findSectionForCourse(course4);
		assertEquals(2, secForCourse1.size());
		assertEquals(1, secForCourse2.size());
		assertEquals(1, secForCourse3.size());
		assertEquals(0, secForCourse4.size());

	}

	@Test
	public void validateSectionEnrollments() {
		Section section1 = sectionRepository.findSectionByTitle("SEC4321");
		Section section2 = sectionRepository.findSectionByTitle("SEC5432");
		Section section3 = sectionRepository.findSectionByTitle("SEC6543");
		Section section4 = sectionRepository.findSectionByTitle("SEC7654");
		List<Student> stuInSec1 = dao.findStudentsInSection(section1);
		List<Student> stuInSec2 = dao.findStudentsInSection(section2);
		List<Student> stuInSec3 = dao.findStudentsInSection(section3);
		List<Student> stuInSec4 = dao.findStudentsInSection(section4);
		assertEquals(1, stuInSec1.size());
		assertEquals(2, stuInSec2.size());
		assertEquals(1, stuInSec3.size());
		assertEquals(0, stuInSec4.size());
	}

	@Test
	public void validateStudentEnrollments() {
		Student student1 = studentRepository.findPersonByUsername("alice");
		Student student2 = studentRepository.findPersonByUsername("bob");
		Student student3 = studentRepository.findPersonByUsername("charlie");
		Student student4 = studentRepository.findPersonByUsername("dan");
		Student student5 = studentRepository.findPersonByUsername("edward");
		Student student6 = studentRepository.findPersonByUsername("frank");
		Student student7 = studentRepository.findPersonByUsername("gregory");
		List<Section> secForStu1 = dao.findSectionsForStudent(student1);
		List<Section> secForStu2 = dao.findSectionsForStudent(student2);
		List<Section> secForStu3 = dao.findSectionsForStudent(student3);
		List<Section> secForStu4 = dao.findSectionsForStudent(student4);
		List<Section> secForStu5 = dao.findSectionsForStudent(student5);
		List<Section> secForStu6 = dao.findSectionsForStudent(student6);
		List<Section> secForStu7 = dao.findSectionsForStudent(student7);
		assertEquals(2, secForStu1.size());
		assertEquals(1, secForStu2.size());
		assertEquals(1, secForStu3.size());
		assertEquals(0, secForStu4.size());
		assertEquals(0, secForStu5.size());
		assertEquals(0, secForStu6.size());
		assertEquals(0, secForStu7.size());
	}

	@Test
	public void validateSectionSeats() {
		Section section1 = sectionRepository.findSectionByTitle("SEC4321");
		Section section2 = sectionRepository.findSectionByTitle("SEC5432");
		Section section3 = sectionRepository.findSectionByTitle("SEC6543");
		Section section4 = sectionRepository.findSectionByTitle("SEC7654");
		assertEquals(49, section1.getSeats());
		assertEquals(48, section2.getSeats());
		assertEquals(49, section3.getSeats());
		assertEquals(50, section4.getSeats());
	}

	

}
