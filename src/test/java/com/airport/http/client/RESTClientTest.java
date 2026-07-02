
/*
 * FirstSipSolutions
 * Author: Justin and Chris
 * SD 15: 2026
 */


package com.airport.http.client;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

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
        mockHttpClient = Mockito.mock(HttpClient);

        mockHttpResponse = Mockito.mock(HttpClient.class);
        restClient.setClient(mockHttpClient);




    }










}

