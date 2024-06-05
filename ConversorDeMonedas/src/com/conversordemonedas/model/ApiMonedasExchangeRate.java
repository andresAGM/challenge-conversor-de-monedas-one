package com.conversordemonedas.model;

import com.conversordemonedas.records.MonedaExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMonedasExchangeRate
{
    //Se crea una variable con la api key: se obtiene registrandose en la pagina de exchangerate-api.com
    private String apiKey = "dacf18b96aeb40ddef958708";

    public void CurrencyConverter(String from, String to, double cantidad)
    {
        //Se crea la url con la api key y las monedas a convertir que se pasan por parametro desde el main
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + from + "/" + to + "/" + cantidad;

        try
        {
            //Se crea un objeto de la clase HttpClient
            HttpClient client = HttpClient.newHttpClient();

            //Se crea un objeto de la clase HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            //Se envia la peticion a la url
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Se crea un objeto de la clase Gson para deserializar el json
            Gson gson = new GsonBuilder()
                    //se utilizo LOWER_CASE_WITH_UNDERSCORES PORQUE EL JSON VIENE EN SNAKE_CASE
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            //Se deserializa el json y se convierte en un objeto de la clase Moneda
            MonedaExchangeRate moneda = gson.fromJson(response.body(), MonedaExchangeRate.class);

            //Se muestra el resultado de la conversion
            //en formato: cantidad origen son cantidad destino
            //ejemplo: "$1.0 USD son $100.0 ARS"
            System.out.print(from + " son $" + moneda.conversion_result());
        }
        catch (Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
