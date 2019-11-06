package edu.northeastern.cs5200.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.jpa.models.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

	@Query("SELECT faculty FROM Faculty faculty where faculty.firstName =:firstName")
	public Faculty findFacultyByFirstName(@Param("firstName") String firstName);

	/*
	 * @Query("SELECT person FROM Person person WHERE person.username=:username")
	 * public Faculty findPersonByUsername(@Param("username") String username);
	 */
}
