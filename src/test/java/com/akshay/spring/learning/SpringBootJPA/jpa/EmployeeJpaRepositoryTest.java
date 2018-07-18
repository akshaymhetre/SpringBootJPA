package com.akshay.spring.learning.SpringBootJPA.jpa;

import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)   // This launches entire spring context
@SpringBootTest(classes = SpringBootJpaApplication.class)
public class EmployeeJpaRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeJpaRepository employeeJpaRepository;

    @Test
    public void findById() {
        final Employee employee = employeeJpaRepository.findById(1L);
        assertEquals(employee.getName(), "akshay");
    }

    @Test
    @DirtiesContext // <-- As below test is modifying database state, this annotation will reset the state after running test
    public void deleteById() { // If transactional not added following code will give exception, as there are multiple statements
        employeeJpaRepository.deleteById(1);
        assertNull(employeeJpaRepository.findById(1));
    }

    @Test
    @DirtiesContext
    public void save() {
        final Employee employee = employeeJpaRepository.findById(1L);
        assertEquals(employee.getName(), "akshay");
        employee.setName("aks");
        employeeJpaRepository.save(employee);
        final Employee employeeNew = employeeJpaRepository.findById(1L);
        assertEquals(employeeNew.getName(), "aks");

    }

    @Test
    public void sortedMap() {

        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("asd", 2);
            put("asf", 45);
            put("a", 4);
            put("b", 4);
        }};
        Map<String, Integer> sortedMap = getStringIntegerMap(map);

        System.out.println("Sorting");
        sortedMap.entrySet().forEach(System.out::println);

    }

    private <K, V extends Comparable<V>> Map<K, V> getStringIntegerMap(Map<K, V> map) {

        return map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }




    private <K, V extends Comparable<V>> Map<K, V> getStringIntegerMap2(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        list.forEach(entry -> result.put(entry.getKey(), entry.getValue()));
        return result;
    }
}