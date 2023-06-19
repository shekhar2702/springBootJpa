package com.example.springbootjpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String groupName;

    @ManyToMany
    @JoinTable(name = "joinTableCustomName",
    joinColumns = @JoinColumn(name = "emailGroupId"),
    inverseJoinColumns = @JoinColumn(name = "employeeId"))
    private List<Employee> employees = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployeeToEmailGroup(Employee employee) {
        this.employees.add(employee);
    }
}
