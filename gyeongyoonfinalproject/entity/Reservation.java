package com.example.gyeongyoonfinalproject.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private long id;
    private String name;
    private User user;
    private Car car;
    private LocalDate date;
    private LocalTime time;

    public Reservation(long id, String name, User user, Car car, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.car = car;
        this.date = date;
        this.time = time;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
