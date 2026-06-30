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

    // the aircraft list is what answers our documentation uqestion for number 2
    // (aircraft per passenger)

    private List<AircraftDTO> aircraft;




    public PassengerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AircraftDTO> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<AircraftDTO> aircraft) {
        this.aircraft = aircraft;
    }
}