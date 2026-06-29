package com.airport.city;

public class CityDTO {

    private Long id;
    private String name;
    private String state;
    private int population;

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

    @Override
    public String toString() {

        return "CityDTO - " +
                "Id: " + id +
                ", Name: " + name + '\'' +
                ", State: " + state + '\'' +
                ", Population:" + population;

    }
}
