
/*
 * FirstSipSolutions
 * Author: Justin and Chris
 * SD 15: 2026
 */

package com.airport.http.client;



import com.airport.passenger.PassengerDTO;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RESTClientTest {

// testing variables that will be needed

    private HttpClient mockHttpClient;
    private RESTClient restClient;

    private HttpResponse<String> mockResponse;



    // Testing started here
    // it will run before each test
    @BeforeEach
    public void setup() {

        restClient = new RESTClient();
        restClient.setServerURL("http://localhost:8080/api/passengers");

        // mocking here for the mockito endpoint testing
        mockHttpClient = Mockito.mock(HttpClient.class);
        mockResponse = Mockito.mock(HttpResponse.class);
        restClient.setClient(mockHttpClient);

    }

    @Test
    public void getAllPassengersThenReturnPassPerAircraft() throws Exception{

        //copied this part from postman collection
        // as it was faster than trying to handle all the details by hand

        String fakeJson = "{ \"content\": [ { \"id\": 1, \"firstName\": \"Chris\", \"lastName\": \"Britten\", "
                + "\"phoneNumber\": \"9025551234\", \"aircraft\": [ { \"id\": 1, \"type\": \"Boeing 737\", "
                + "\"airlineName\": \"Air Canada\", \"numberOfPassengers\": 160 } ] } ] }";

        // this is telling the response what to send back
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(fakeJson);

        when(mockHttpClient.send(any(HttpRequest.class),any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);
        List<PassengerDTO> passengers = restClient.getAllPassengers();

        assertEquals(1, passengers.size());
        assertEquals("Chris", passengers.get(0).getFirstName());

        // here is the question 2 response
        // mocked out and testing each value will be consistent
        assertEquals(1, passengers.get(0).getAircraft().size());
        assertEquals("Boeing 737", passengers.get(0).getAircraft().get(0).getType());
    }

    }












