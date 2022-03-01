package com.example.ase.person;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity
@Table(name="people")
public class Person {
    @Id
    @GeneratedValue(strategy =
    GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private Integer zipcode;
    private String city;
    private String color;

    public Person() {}

    public Person(Integer id, String name, String lastname, Integer zipcode, String city, String color) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.zipcode = zipcode;
        this.city = city;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
