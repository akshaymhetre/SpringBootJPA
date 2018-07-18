package com.akshay.spring.learning.SpringBootJPA.jpa;

import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Passport;
import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}


