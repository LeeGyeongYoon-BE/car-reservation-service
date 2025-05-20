package com.example.gyeongyoonfinalproject.dao;

import com.example.gyeongyoonfinalproject.entity.Car;
import com.example.gyeongyoonfinalproject.exception.CarNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static List<Car> cars = new ArrayList<>();
    private static long idCounter = 1;

    public Car addCar(Car car) {
        car.setId(idCounter++);
        cars.add(car);
        return car;
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(long id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("차량이 없습니다"));
    }

    public Car getLastCar() {
        if (cars.isEmpty()) {
            throw new CarNotFoundException("차량이 없습니다.");
        }
        return cars.get(cars.size() - 1);
    }
}
