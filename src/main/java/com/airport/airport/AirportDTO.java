package com.airport.airport;

public class AirportDTO {

    private Long id;
    private String name;
    private String code;

    public AirportDTO(){}

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AirportDTO - " +
                "Id: " + id +
                ", Name: " + name + '\'' +
                ", Code: " + code + '\'' ;
    }
}
