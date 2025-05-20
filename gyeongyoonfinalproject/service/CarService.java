package com.example.gyeongyoonfinalproject.service;

import com.example.gyeongyoonfinalproject.entity.Car;
import com.example.gyeongyoonfinalproject.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private static List<Car> cars = new ArrayList<>();
    private static long carId = 1;

    public Car addCar(String name, int price, String owner, int year) {
        if (cars.size() >= 5) {
            throw new BadRequestException("차량은 최대 5대까지 등록할 수 있습니다.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("차량 이름은 필수이며, 공백일 수 없습니다.");
        }

        if (price <= 0) {
            throw new BadRequestException("차량 가격은 0보다 커야 합니다.");
        }

        if (owner == null || owner.trim().isEmpty()) {
            throw new BadRequestException("차량 소유자는 필수이며, 공백일 수 없습니다.");
        }

        if (year <= 1950) {
            throw new BadRequestException("차량 연식은 1950년 보다 커야 합니다.");
        }

        Car car = new Car(carId++, name, price, owner, year);
        cars.add(car);
        return car;
    }

    public List<Car> getAllCars() {
        if (cars.isEmpty()) {
            throw new BadRequestException("차량이 없습니다.");
        }
        return cars;
    }

    public Optional<Car> getCarById(long id) {
        return cars.stream().filter(c -> c.getId() == id).findFirst();
    }

    public Car getLastCar() {
        if (cars.isEmpty()) {
            throw new BadRequestException("차량이 없습니다.");
        }
        return cars.get(cars.size() - 1);  // 마지막 차량 반환
    }
}
