package com.example.springbootjpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQuery(query = "select e from Employee e",name = "kuchBhi")
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }
//    private EmployeeType type;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @OneToOne(fetch = FetchType.LAZY)
    private AccessCard accessCard;

    public List<PaySlip> getPaySlips() {
        return paySlips;
    }

    public void setPaySlips(List<PaySlip> paySlips) {
        this.paySlips = paySlips;
    }

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    List<PaySlip> paySlips;

    @ManyToMany(mappedBy = "employees")
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    @Transient
    private String dontPersistThis;

    public String getDontPersistThis() {
        return dontPersistThis;
    }

    public void setDontPersistThis(String dontPersistThis) {
        this.dontPersistThis = dontPersistThis;
    }

    public Date getDob() {
        return dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "empName")
    private String name;

    @Temporal(TemporalType.TIME)
    private Date dob;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    @Column(nullable = false,unique = true)
    private String ssn;

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", type=" + type +
                ", accessCard=" + accessCard +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
//                ", paySlips='" + paySlips + '\'' +
                '}';
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addEmployeeToEmailGroup(EmailGroup emailGroup) {
        this.emailGroups.add(emailGroup);
    }
}
