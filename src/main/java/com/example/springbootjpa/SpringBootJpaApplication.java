package com.example.springbootjpa;

import com.example.springbootjpa.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootJpaApplication {

//    @PersistenceUnit
//    private EntityManagerFactory emf;

//    @PersistenceContext
//    private EntityManager entityManager;
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @PostConstruct
    public void start() {
//        EntityManager entityManager = emf.createEntityManager();
//        Employee employee = new Employee();
//        employee.setAge(12);
//        employee.setName("kekfek");
//        employee.setSsn("dff");

//        EntityTransaction entityTransaction =entityManager.getTransaction();
//        entityTransaction.begin();
//        entityManager.persist(employee);
//        entityTransaction.commit();
//        Employee employee = entityManager.find(Employee.class,1);
        Optional<Employee> employee = employeeRepository.findById(1);
        updateEmployee(employee.get());
        System.out.println(employee);


    }
    @Transactional
        public void updateEmployee(Employee employee) {
        employee.setName("updated name");
        employeeRepository.save(employee);
        }
}
