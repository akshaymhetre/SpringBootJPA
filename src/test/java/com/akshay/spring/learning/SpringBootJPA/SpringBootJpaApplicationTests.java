package com.akshay.spring.learning.SpringBootJPA;

import com.akshay.spring.learning.SpringBootJPA.jpa.PassportRepository;
import com.akshay.spring.learning.SpringBootJPA.jpa.SpringBootJpaApplication;
import com.akshay.spring.learning.SpringBootJPA.jpa.StudentRepository;
import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Passport;
import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootJpaApplication.class})
public class SpringBootJpaApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	PassportRepository passportRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	@Transactional
	public void retrieveStudentAndPAssportDetails(){
		final Optional<Student> studentRepositoryById = studentRepository.findById(1L);

		studentRepositoryById.ifPresent(student -> {
			logger.info("Print student {}", student);
			final Passport passport = student.getPassport();
			logger.info("passport {}", passport);

		} );
	}

}
