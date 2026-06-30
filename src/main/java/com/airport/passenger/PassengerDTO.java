package com.airport.passenger;

import com.airport.aircraft.AircraftDTO;

import java.util.List;

public class PassengerDTO {

    // this is all taken from the DB via the API
    // using Long for Id and String for the rest
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<AircraftDTO> aircraft;

