package com.airport.http.cli;

import com.airport.city.CityDTO;
import com.airport.http.client.CityRESTClient;

import java.util.List;

public class HttpRestCLIApp {
    private CityRESTClient cityRestClient;

    public String generateCityReport() {
        List<CityDTO> cities = getCityRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (CityDTO cityDTO : cities) {
            report.append(cityDTO.getName());
            report.append(" - ");
            report.append(cityDTO.getCode());

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

    public CityRESTClient getCityRestClient() {
        if (cityRestClient == null) {
            cityRestClient = new CityRESTClient();
        }

        return cityRestClient;
    }

    public void setCityRestClient(CityRESTClient cityRestClient) {
        this.cityRestClient = cityRestClient;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        HttpRestCLIApp cliApp = new HttpRestCLIApp();

        String serverURL = args[0];

        if (serverURL != null && !serverURL.isEmpty()) {

            CityRESTClient cityRestClient = new CityRESTClient();
            cityRestClient.setServerURL(serverURL);

            cliApp.setCityRestClient(cityRestClient);

            if (serverURL.contains("greeting")) {
                cliApp.listGreetings();
            } else {
                cliApp.generateCityReport();
            }
        }

    }


}
