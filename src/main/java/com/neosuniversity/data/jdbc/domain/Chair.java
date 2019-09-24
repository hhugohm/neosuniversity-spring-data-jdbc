package com.neosuniversity.data.jdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Class representing a chairperson of a department.
 * <p>
 * Created by maryellenbowman
 */
@Table("CHAIR")
public class Chair {
    @Id
    private int department;

    private String name;

    public Chair(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "department=" + department +
                ", name='" + name + '\'' +
                '}';
    }
}