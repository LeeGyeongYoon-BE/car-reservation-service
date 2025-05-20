package com.example.gyeongyoonfinalproject.entity;


public class Car {

    private long id;
    private String name;
    private int price;
    private String owner;
    private int year;

    public Car(long id, String name, int price, String owner, int year) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.year = year;
    }

    // Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
