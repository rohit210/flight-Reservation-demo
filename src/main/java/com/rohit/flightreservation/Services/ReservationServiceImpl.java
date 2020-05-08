package com.rohit.flightreservation.Services;

import com.rohit.flightreservation.Repository.FlightRepository;
import com.rohit.flightreservation.Repository.PassengerRepository;
import com.rohit.flightreservation.Repository.ReservationRepository;
import com.rohit.flightreservation.Utill.EmilUtil;
import com.rohit.flightreservation.Utill.PDFGenerator;
import com.rohit.flightreservation.dto.ReservationRequest;
import com.rohit.flightreservation.entities.Flight;
import com.rohit.flightreservation.entities.Passenger;
import com.rohit.flightreservation.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationServices {
    @Value("${com.rohit.flightreservation.itinarary.dirpath}")
    private   String Itinarary_DIR ;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    PDFGenerator pdfGenerator;
    @Autowired
    EmilUtil emilUtil;

    @Override
    public Reservation bookFlight(ReservationRequest request) {
        //make payment

        Long id = request.getId();
        Flight flight = flightRepository.getOne(id);
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPfirstName());
        passenger.setLastName(request.getPlastName());
        passenger.setPhone(request.getPphone());
        passenger.setEmail(request.getPemail());
        Passenger savedPassenger = passengerRepository.save(passenger);


        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);
        String filePath = Itinarary_DIR + savedReservation.getId() + ".pdf";
        pdfGenerator.generateItinarary(savedReservation, filePath);
        emilUtil.sendItinanry(passenger.getEmail(), filePath);
        return savedReservation;
    }
}
