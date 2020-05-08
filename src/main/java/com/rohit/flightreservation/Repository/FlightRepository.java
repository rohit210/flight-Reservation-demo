package com.rohit.flightreservation.Repository;

import com.rohit.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
  @Query("from Flight where departureCity=:deparuteCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
   List<Flight> findFlights(@Param("deparuteCity") String from, @Param("arrivalCity")String to, @Param("dateOfDeparture") Date departureDate);
}
