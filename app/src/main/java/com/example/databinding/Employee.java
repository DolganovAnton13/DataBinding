package com.example.databinding;

import android.view.View;

public class Employee {

    public Employee(long id, String name, String address, int salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Employee(){}

    public long id;

    public String name;

    public String address;

    public int salary;

}