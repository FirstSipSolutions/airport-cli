package com.airport.http.cli;

import com.airport.city.CityDTO;
import com.airport.http.client.RESTClient;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;
import com.airport.passenger.PassengerDTO;
import com.airport.aircraft.AircraftDTO;
import com.airport.airport.AirportDTO;


import java.util.List;

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class HttpRestCLIApp {
    private RESTClient restClient;

    public String generateCityReport() {
        List<CityDTO> cities = getRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (CityDTO cityDTO : cities) {
            report.append(cityDTO.getName());
            report.append(" - ");
            report.append(cityDTO.getState());

            if (cities.indexOf(cityDTO) != (cities.size() - 1)) {
                report.append(", ");
            }
        }

        System.out.println(report);

        return report.toString();
    }

    private void listGreetings() {
        System.out.println(getRestClient().getResponseFromHTTPRequest());
    }

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Please provide the API Server URL as an argument.");
            return;
        }

        for (String arg : args) {
            System.out.println(arg);
        }

        HttpRestCLIApp cliApp = new HttpRestCLIApp();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            if (serverURL.contains("greeting")) {
                cliApp.listGreetings();

        } else if (serverURL.contains("passengers")) {
                cliApp.generatePassengerReport();
            } else if (serverURL.contains("aircraft")) {
                cliApp.generateAircraftReport();
            }
            else {
                cliApp.generateCityReport();
            }

        }
    }

    // ----------------------------------------------------------------
    // Passenger response for listing report via pass and plane corilation
    // what aircraft has each passenger in it for question 2 here
    // this will be getting passengers ...then for each pass it will print the name and the aircraft

    public String generatePassengerReport() {

        List<PassengerDTO> passengers = getRestClient().getAllPassengers();

        StringBuffer report = new StringBuffer();

        for (PassengerDTO passenger : passengers) {
            report.append(passenger.getFirstName() + " " + passenger.getLastName() + " flew on: ");

            for (AircraftDTO aircraft : passenger.getAircraft()) {
                report.append(aircraft.getType() + " ");
            }

            report.append("\n");
        }

        System.out.println(report.toString());
        return report.toString();
    }

// ----------------------------------------------------------------
// Aircraft response for listing report via airport and plane
// what aircraft it is for question 3 here
// this will be getting aircrafts ...then for each one it will print the name and the aircraft
public String generateAircraftReport() {

    List<AircraftDTO> aircraft = getRestClient().getAllAircraft();

    StringBuffer report = new StringBuffer();

    for (AircraftDTO plane : aircraft) {
        report.append(plane.getType() + " flies to: ");

        for (AirportDTO airport : plane.getAirports()) {
            report.append(airport.getName() + " ");
        }

        report.append("\n");
    }

    System.out.println(report.toString());
    return report.toString();
}

}