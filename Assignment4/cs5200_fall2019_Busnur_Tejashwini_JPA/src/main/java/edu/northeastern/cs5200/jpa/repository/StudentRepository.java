package edu.northeastern.cs5200.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.jpa.models.Faculty;
import edu.northeastern.cs5200.jpa.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("SELECT person FROM Person person WHERE person.username=:username")
	public Student findPersonByUsername(@Param("username") String username);

	@Query("SELECT student FROM Student student where student.firstName =:firstName")
	public Student findStudentByFirstName(@Param("firstName") String firstName);

}
