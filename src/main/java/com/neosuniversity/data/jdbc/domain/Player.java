package com.neosuniversity.data.jdbc.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashMap;
import java.util.Map;

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


    // relation one to one
    private Country country;

    // relation one to many
    private Map<Integer,Hobby> mapTeam = new HashMap<>();

    public Player(){}

    public Player(String name, String last, Country country) {
        this.name = name;
        this.last = last;
        this.country = country;
    }

    public Player(String name, String last, Country country, Map<Integer, Hobby> mapTeam) {
        this.name = name;
        this.last = last;
        this.country = country;
        this.mapTeam = mapTeam;
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

    public Map<Integer, Hobby> getMapTeam() {
        return mapTeam;
    }

    public void setMapTeam(Map<Integer, Hobby> mapTeam) {
        this.mapTeam = mapTeam;
    }
}
