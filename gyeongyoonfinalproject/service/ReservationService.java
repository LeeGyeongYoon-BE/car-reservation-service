package com.example.gyeongyoonfinalproject.service;

import com.example.gyeongyoonfinalproject.entity.Car;
import com.example.gyeongyoonfinalproject.entity.Reservation;
import com.example.gyeongyoonfinalproject.entity.User;
import com.example.gyeongyoonfinalproject.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    private static List<Reservation> reservations = new ArrayList<>();
    private static long reservationId = 1;

    public Reservation addReservation(String name, long userId, long carId, LocalDate date, LocalTime time) {
        if (reservations.size() >= 10) {
            throw new BadRequestException("예약은 최대 10개까지 등록할 수 있습니다.");
        }

        // 유저와 차량 정보 가져오기
        User user = userService.getUserById(userId).orElseThrow(() -> new BadRequestException("유저 ID가 존재하지 않습니다."));
        Car car = carService.getCarById(carId).orElseThrow(() -> new BadRequestException("차량 ID가 존재하지 않습니다."));

        Reservation reservation = new Reservation(reservationId++, name, user, car, date, time);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        if (reservations.isEmpty()) {
            throw new BadRequestException("예약이 없습니다.");
        }
        return reservations;
    }

    public Reservation getReservation(long id) {
        return reservations.stream().filter(r -> r.getId() == id).findFirst().orElseThrow(() -> new BadRequestException("예약 ID가 존재하지 않습니다."));
    }
}
