package com.example.room.model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String detail;
    private double price;
    private boolean status;
    private int numberOfPerson;
    private int numberBed;

    public Phong() {
    }

    public Phong(String name, String detail, double price, boolean status, int numberOfPerson, int numberBed) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.status = status;
        this.numberOfPerson = numberOfPerson;
        this.numberBed = numberBed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(int numberBed) {
        this.numberBed = numberBed;
    }
}
