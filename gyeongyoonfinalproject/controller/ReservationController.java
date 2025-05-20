package com.example.gyeongyoonfinalproject.controller;

import com.example.gyeongyoonfinalproject.entity.Reservation;
import com.example.gyeongyoonfinalproject.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gyeongyoonfinalproject.service.ReservationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation addReservation(@RequestParam String name, @RequestParam long userId, @RequestParam long carId, LocalDate date, LocalTime time) {
        try {
            return reservationService.addReservation(name, userId, carId, date, time);
        } catch (BadRequestException ex) {
            throw ex;
        }
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/single")
    public Reservation getReservation(@RequestParam long id) {
        return reservationService.getReservation(id);
    }
}
