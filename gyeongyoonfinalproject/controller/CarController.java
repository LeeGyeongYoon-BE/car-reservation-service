package com.example.gyeongyoonfinalproject.controller;

import com.example.gyeongyoonfinalproject.entity.Car;
import com.example.gyeongyoonfinalproject.exception.BadRequestException;
import com.example.gyeongyoonfinalproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;


    @PostMapping
    public Car addCar(@RequestParam String name, @RequestParam int price, @RequestParam String owner, @RequestParam int year) {
        try {
            return carService.addCar(name, price, owner, year);
        } catch (BadRequestException ex) {
            throw ex;
        }
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/last")
    public ResponseEntity<Car> getLastCar() {
        Car lastCar = carService.getLastCar();
        if (lastCar != null) {
            return ResponseEntity.ok(lastCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
