package com.akshay.spring.learning.SpringBootJPA.jpa;

import com.akshay.spring.learning.SpringBootJPA.jdbc.entity.Person;
import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class EmployeeJpaRepository {
    @PersistenceContext
    EntityManager entityManager; // Interface to connect to persistence context

    public Employee findById(long id){
        return entityManager.find(Employee.class, id);
    }

    public Employee update(Employee employee){
        return entityManager.merge(employee); // If id is present it will update otherwise insert
    }

    public Employee save(Employee employee){
        if(employee.getId() == null){
            entityManager.persist(employee);
        }else {
            entityManager.merge(employee);
        }
        return employee;
    }

    public void deleteById(long id){
        final Employee employee = findById(id);
        entityManager.remove(employee);
    }

    public List<Employee> findAll(){ // Uses JPQL feature, which queries entities, look entity for query definition
        final TypedQuery<Employee> find_all_employees = entityManager.createNamedQuery("find_all_employees", Employee.class);
        return find_all_employees.getResultList();
    }

    public void playWithEntityManager(){
        final Employee employee = new Employee("vaibhav", "bibewadi", new Date());
        entityManager.persist(employee);

        employee.setLocation("pune"); // <--- this will still save data in DB as we have added transaction, it will keep track
        entityManager.flush(); // <--- This will immediately flush data to db
        employee.setBirthDate(new Date()); // This will still get saved


        final Employee employee1 = new Employee("sheetal", "PS", new Date());
        entityManager.persist(employee1);
        entityManager.detach(employee1);
        employee.setLocation("pune"); // <--- This will not get saved as used detached

        //  You might have updated employee at sevral places, This will refresh employee object with updated data
        entityManager.refresh(employee);
        entityManager.clear(); // <-- This will clear everything like calling detach for all



    }
}
