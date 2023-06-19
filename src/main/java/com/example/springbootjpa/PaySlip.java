package com.example.springbootjpa;

import jakarta.persistence.*;


@Entity
public class PaySlip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paySlipTo")
    private Employee employee;

    @Override
    public String toString() {
        return "PaySlip{" +
                "id=" + id +
//                ", employee=" + employee +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
