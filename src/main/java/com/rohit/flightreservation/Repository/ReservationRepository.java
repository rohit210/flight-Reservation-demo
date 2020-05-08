package com.rohit.flightreservation.Repository;

import com.rohit.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
