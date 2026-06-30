package com.airport.aircraft;




// importing the List and DTO from the airporrt DTO created
import com.airport.airport.AirportDTO;
import java.util.List;

public class AircraftDTO {

    // This holds aircraft data coming back from the API
    // matches the fields the API needs to send for each aircraft !
    private Long id;
    private String type;
    private String airlineName;
    private int numberOfPassengers;
