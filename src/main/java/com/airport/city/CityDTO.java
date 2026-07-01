package com.airport.city;

import com.airport.airport.AirportDTO;

import java.util.List;

public class CityDTO {

    private Long id;
    private String name;
    private String state;
    private int population;

    private List<AirportDTO> airports;

    public CityDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<AirportDTO> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportDTO> airports) {
        this.airports = airports;
    }

    @Override
    public String toString() {

        return "CityDTO - " +
                "Id: " + id +
                ", Name: " + name + '\'' +
                ", State: " + state + '\'' +
                ", Population:" + population;

    }
}
