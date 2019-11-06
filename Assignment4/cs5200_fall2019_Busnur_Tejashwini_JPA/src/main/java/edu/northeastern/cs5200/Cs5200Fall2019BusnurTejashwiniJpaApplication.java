package edu.northeastern.cs5200;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.northeastern.cs5200.jpa.dao.UniversityDao;
import edu.northeastern.cs5200.jpa.models.Student;
import edu.northeastern.cs5200.jpa.repository.StudentRepository;

@SpringBootApplication
public class Cs5200Fall2019BusnurTejashwiniJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Fall2019BusnurTejashwiniJpaApplication.class, args);
		
		

	}

}
