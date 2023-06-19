package com.example.springbootjpa;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication {

//    @PersistenceUnit
//    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager entityManager;

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
        Employee employee = entityManager.find(Employee.class,1);

        System.out.println(employee);


    }

}
