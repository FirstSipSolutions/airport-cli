package com.airport.http.client;

import com.airport.city.CityDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.airport.passenger.PassengerDTO;
import com.airport.aircraft.AircraftDTO;
public class RESTClient {
    private String serverURL;
    private HttpClient client;

    public String getResponseFromHTTPRequest() {
        String responseBody = "";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("Status Code: " + response.statusCode());
            }

            responseBody = response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return responseBody;
    }

    public List<CityDTO> getAllCities() {
        List<CityDTO> cities = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();

        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                cities = buildCityListFromResponse(response.body());
            } else {
                System.out.println("Error Status Code: " + response.statusCode());
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public List<CityDTO> buildCityListFromResponse(String response) throws JsonProcessingException {
        List<CityDTO> cities;

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonNode rootNode = mapper.readTree(response);
        JsonNode contentNode = rootNode.get("content");

        String arrayString = contentNode.toString();
        cities = mapper.readValue(arrayString, new TypeReference<>() {
        });

        return cities;
    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    public HttpClient getClient() {
        if (client == null) {
            client = HttpClient.newHttpClient();
        }

        return client;
    }

// -------------------------------------------------------------------------
//Passenger Here - this will be the repsonse for Question 2 in documnetation
// This will call on the API, then returns a list of passengers

    public List<PassengerDTO> getAllPassengers() {

        List<PassengerDTO> passengers = new ArrayList<PassengerDTO>();

        // Request line will create a new serverURL for building out the response
        //Hopefully
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();


        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                passengers = buildPassengerListFromResponse(response.body());
            } else {
                System.out.println("Error Status Code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return passengers;

    }

    public List<PassengerDTO> buildPassengerListFromResponse(String response) throws JsonProcessingException {

        List<PassengerDTO> passengers = new ArrayList<PassengerDTO>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        JsonNode rootNode = mapper.readTree(response);
        JsonNode contentNode = rootNode.get("content");

        String arrayString = contentNode.toString();
        passengers = mapper.readValue(arrayString, new TypeReference<List<PassengerDTO>>() {
        });

        return passengers;
    }


// -------------------------------------------------------------------------
//Aircraft Here - this will be the repsonse for Question 3 in documnetation
// This will call on the API, then returns a list of aircraft per the question

    public List<AircraftDTO> getAllAircraft() {

        List<AircraftDTO> aircraft = new ArrayList<AircraftDTO>();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL)).build();


        // try catch for hadling statsu and request for hhtp to string
        // this will make sure the statu code will be relative to the response
        try {
            HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                aircraft = buildAircraftListFromResponse(response.body());

            } else {
                System.out.println("Error Status Code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return aircraft;
    }

    public List<AircraftDTO> buildAircraftListFromResponse(String response) throws JsonProcessingException {

        List<AircraftDTO> aircraft = new ArrayList<AircraftDTO>();


        // mapping object for deserilization here
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


        // this no longer requires root node for "content" due to aircraft not having a content line
        aircraft = mapper.readValue(response, new TypeReference<List<AircraftDTO>>() {
        });

       // removed mapper and to string as its not needed for this aircraft response

        return aircraft;
    }

}




