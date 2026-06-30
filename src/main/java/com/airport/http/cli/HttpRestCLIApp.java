package com.airport.http.cli;

import com.airport.city.CityDTO;
import com.airport.http.client.RESTClient;

import java.util.List;

public class HttpRestCLIApp {
    private RESTClient restClient;

    public String generateCityReport() {
        List<CityDTO> cities = getCityRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (CityDTO cityDTO : cities) {
            report.append(cityDTO.getName());
            report.append(" - ");
            report.append(cityDTO.getState());

            if (cities.indexOf(cityDTO) != (cities.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    private void listGreetings() {
        System.out.println(getCityRestClient().getResponseFromHTTPRequest());
    }

    public RESTClient getCityRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setCityRestClient(RESTClient restClient) {
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

            cliApp.setCityRestClient(restClient);

            if (serverURL.contains("greeting")) {
                cliApp.listGreetings();
            } else {
                cliApp.generateCityReport();
            }
        }
    }
}