package com.neosuniversity.data.jdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
/**
 * JDBC Entity for a Department of study at the University.
 * <p>
 * Created by maryellenbowman
 */
@Table(value = "DEPARTMENT")
public class Department {
    @Id
    private Integer id;

    private String name;

    private Chair chair;

    public Department(String name, Chair chair) {

        this.name = name;
        this.chair = chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Chair getChair() {
        return chair;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chair=" + chair +
                '}';
    }
}