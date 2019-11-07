package edu.northeastern.cs5200.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.jpa.models.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
	
	@Query("SELECT enrollment FROM Enrollment enrollment WHERE enrollment.student.id = :studentId")
    public List<Enrollment> findEnrollments(@Param("studentId") Integer studentId);

}
