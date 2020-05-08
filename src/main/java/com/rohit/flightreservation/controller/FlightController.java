package com.rohit.flightreservation.controller;

import com.rohit.flightreservation.Repository.FlightRepository;
import com.rohit.flightreservation.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller

public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap modelMap) {
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flight", flights);
        return "displayFlights";
    }


}
