package com.rohit.flightreservation.controller;

import com.rohit.flightreservation.Repository.FlightRepository;
import com.rohit.flightreservation.Services.ReservationServices;
import com.rohit.flightreservation.dto.ReservationRequest;
import com.rohit.flightreservation.entities.Flight;
import com.rohit.flightreservation.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/showCompleteReservation")
public class ReservationControler {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationServices reservationServices;

    @GetMapping(value = "/showCompleteReservation/{id}")
    public ModelAndView showReservation(@PathVariable("id") long id) {
        Flight flight = flightRepository.getOne(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("completeReservation");
        modelAndView.addObject("details", new ReservationRequest());
        modelAndView.addObject("flight", flight);
        modelAndView.addObject("id", id);

        return modelAndView;
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String CompleteReservation( ReservationRequest request, Model model) {
        Reservation reservation = reservationServices.bookFlight(request);
        model.addAttribute("msg", "Reservation created successfully and id is " + reservation.getId());
        return "reservationConfirmation";
    }

}
