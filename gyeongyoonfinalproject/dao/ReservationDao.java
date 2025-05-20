package com.example.gyeongyoonfinalproject.dao;

import com.example.gyeongyoonfinalproject.entity.Reservation;
import com.example.gyeongyoonfinalproject.exception.ReservationNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ReservationDao {
    private static List<Reservation> reservations = new ArrayList<>();
    private static long idCounter = 1;

    public Reservation addReservation(Reservation reservation) {
        reservation.setId(idCounter++);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationById(long id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ReservationNotFoundException("예약 ID가 존재하지 않습니다."));
    }
}
