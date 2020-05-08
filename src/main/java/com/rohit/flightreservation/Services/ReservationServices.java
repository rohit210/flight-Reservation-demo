package com.rohit.flightreservation.Services;
import com.rohit.flightreservation.dto.ReservationRequest;
import com.rohit.flightreservation.entities.Reservation;
public interface ReservationServices {

    Reservation bookFlight(ReservationRequest request);

}
