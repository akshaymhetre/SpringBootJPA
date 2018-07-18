package com.akshay.spring.learning.SpringBootJPA.jpa;

import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

}