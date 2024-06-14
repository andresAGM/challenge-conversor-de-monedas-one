package com.conversordemonedas.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMonedasExchangeRate
{
    //Se crea una variable con la api key: se obtiene registrandose en la pagina de exchangerate-api.com
    private String apiKey = "YOUR API KEY HERE";

    public String CurrencyConverter(String from, String to, double cantidad)
    {
        //Se crea la url con la api key y las monedas a convertir que se pasan por parametro desde el main
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" + from + "/" + to + "/" + cantidad;

            //Se crea un objeto de la clase HttpClient
            HttpClient client = HttpClient.newHttpClient();

            //Se crea un objeto de la clase HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = null;
            try
            {
                //Se envia la peticion a la url
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception e)
            {
                System.out.println("Error: "+e.getMessage());
            }

            //Se retorna el json
            String json = response.body();
            return json;
    }
}
