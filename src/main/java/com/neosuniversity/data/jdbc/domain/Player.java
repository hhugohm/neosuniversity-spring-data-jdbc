package com.neosuniversity.data.jdbc.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@JsonRootName(value = "player")
@Table(value = "PLAYER")
public class Player {
    @Id
    @Column(value = "id_player")
    private int id;

    @Column(value = "name_player")
    private  String name;

    @Column(value = "lastname_player")
    private String last;

    private Country country;


    public Player(String name, String last, Country country) {
        this.name = name;
        this.last = last;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + last + '\'' +
                ", country=" + country +
                '}';
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

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
