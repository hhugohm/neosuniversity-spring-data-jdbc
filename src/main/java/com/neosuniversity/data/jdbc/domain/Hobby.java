package com.neosuniversity.data.jdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "HOBBY")
public class Hobby {

    @Id
    private int player;


    private String description;


    public Hobby(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDesciption(String desciption) {
        this.description = desciption;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "description='" + description + '\'' +
                '}';
    }
}
