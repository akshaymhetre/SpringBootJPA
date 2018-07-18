package com.akshay.spring.learning.SpringBootJPA.jpa_inheritance.entity;

import java.math.BigDecimal;

public class PartTimeEmployee extends Employee {

    protected PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    BigDecimal hourlyWage;
}
