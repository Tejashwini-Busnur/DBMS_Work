package edu.northeastern.cs5200.jpa.repository;
import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.jpa.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

}
