package com.akshay.spring.learning.SpringBootJPA.jpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "find_all_employees", query = "select e from Employee e") // <--- JPQL query uses entity to query not jdbc
//@Table(name = "employee_table") // <--- Way to override name default name will be employee
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private Date birthDate;

    public Employee() {
    }

    public Employee(Long id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Employee(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("\nEmployee [id=%s, name= %s, location=%s, birthDate=%s]", getId(), getName(), getLocation(), getBirthDate());
    }
}
