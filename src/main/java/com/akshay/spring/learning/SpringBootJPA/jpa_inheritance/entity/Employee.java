package com.akshay.spring.learning.SpringBootJPA.jpa_inheritance.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_new")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // <--- Default strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // This will create two tables full time employee and part time BUT NOT Employee table
//@Inheritance(strategy = InheritanceType.JOINED) // THis will create 3 tables, with employee id as foreign key in others
@DiscriminatorColumn(name = "EmployeeType") // <--- Assigning name to column created to differentiate type default name is DTYPE
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected Employee() {
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return String.format("\nEmployee [id=%s, name= %s]", getId(), getName());
    }
}

/*
* You can also used @MappedSuperClass which will not create employee table (in this case you will have to remove Entity annotation as well)
* Though @MappedSuperClass and InheritanceType.TABLE_PER_CLASS looks same there is a difference in usecase:
*
* - You can have several kinds of messages: SMS messages, email messages, or phone messages. And a person has a list of messages.
*   You can also have a reminder linked to a message, regardless of the kind of message.
*   In this case, Message is clearly an entity, and entity inheritance must be used.
*
  - All your domain objects could have a creation date, modification date and ID, and you could thus make them inherit from a
  base AbstractDomainObject class. But no entity will ever have an association to an AbstractDomainObject.
  It will always be an association to a more specific entity: Customer, Company, whatever.
  In this case, it makes sense to use a MappedSuperClass.




* */