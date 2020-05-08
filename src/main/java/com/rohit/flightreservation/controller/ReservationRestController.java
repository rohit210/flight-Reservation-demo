package com.rohit.flightreservation.controller;

import com.rohit.flightreservation.Repository.ReservationRepository;
import com.rohit.flightreservation.dto.ReservationUpdateRequest;
import com.rohit.flightreservation.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        return reservationRepository.getOne(id);

    }

    @RequestMapping("/reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.getOne(request.getId());
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        Reservation updatedReservation = reservationRepository.save(reservation);
        return updatedReservation;
    }
}
