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


    //DOcumentation question 3 response here
    // the airports this aircraft flies to will be started from here
    // this listss what answers doc question 3 for the deliverables
    // (airports per aircraft)
    private List<AirportDTO> airports;

    public AircraftDTO() {
    }

    public Long getId() {
        return id;
    };