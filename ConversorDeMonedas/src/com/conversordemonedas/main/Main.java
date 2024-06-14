package com.conversordemonedas.main;

import com.conversordemonedas.model.ApiMonedasExchangeRate;
import com.conversordemonedas.records.MonedaExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //inicializamos Scanner
        Scanner scanner = new Scanner(System.in);
        //vector con las opciones del menu
        String[] opciones = {"Convertir USD a ARG", "Convertir ARG a USD", "Convertir USD a BRL", "Convertir BRL a USD", "Convertir USD a COP", "Convertir COP a USD", "Salir"};


        //Bucle para mostrar el menu
        //Se utiliza el true para que el bucle se ejecute siempre
        //hasta que el usuario decida salir
        while (true)
        {
            System.out.println("#--------------------------------#");
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("#--------------------------------#");

            //mostramos las opciones del menu
            System.out.println("Elija una opción:");
            for (int i = 0; i < opciones.length; i++)
            {
                System.out.println(i + 1 + ". " + opciones[i]);
            }

            //leemos la opcion elegida
            System.out.print("Opcion:");
            int opcion = scanner.nextInt();

            //si la opcion es 7 salimos del bucle
            //sino esta condicion en caso de elegir el 7 no sale del sistema
            //porque continua procesando el codigo
            if (opcion == 7)
            {
                System.exit(0);
            }

            //si la opcion ingresada es diferente de las opciones del menu mostramos un mensaje de error
            if (opcion < 1 || opcion > 7)
            {
                System.out.println("Opción no válida, porfavor elija una opción válida");
                continue;
            }

            //pedimos la cantidad a convertir
            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = 0;

            //validamos que no sea texto
            //preguntara la cantidad a convertir hasta que se ingrese un numero
            while (!scanner.hasNextDouble())
            {
                System.out.println("Por favor ingrese un número decimal válido");
                scanner.next();
            }
            cantidad = scanner.nextDouble();

            /*
             * Creamos un objeto de la clase ApiMonedasExchangeRate
             * y llamamos al metodo CurrencyConverter
             * pasandole como parametros la moneda origen, la moneda destino y la cantidad a convertir
             * Luego mostramos el resultado de la conversion
             * */
            var api = new ApiMonedasExchangeRate();
            //Se crea el objeto Gson
            Gson gson = new GsonBuilder()
                    //se utilizo LOWER_CASE_WITH_UNDERSCORES PORQUE EL JSON VIENE EN SNAKE_CASE
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            switch (opcion)
            {
                case 1:
                    System.out.println("Convirtiendo USD a ARS");
                    var json = api.CurrencyConverter("USD", "ARS", cantidad);
                    MonedaExchangeRate moneda = gson.fromJson(json, MonedaExchangeRate.class);
                    System.out.println("$" + (int) cantidad + " DOLARES" + " son " + "$" + moneda.conversion_result() + " PESOS ARGENTINOS");
                    break;
                case 2:
                    System.out.println("Convirtiendo ARS a USD");
                    var json2 = api.CurrencyConverter("ARS", "USD", cantidad);
                    MonedaExchangeRate moneda2 = gson.fromJson(json2, MonedaExchangeRate.class);
                    System.out.println("$" + cantidad + " PESOS ARGENTINOS" + " son " + "$" + moneda2.conversion_result() + " DOLARES");
                    break;
                case 3:
                    System.out.println("Convirtiendo USD a BRL");
                    var json3 = api.CurrencyConverter("USD", "BRL", cantidad);
                    MonedaExchangeRate moneda3 = gson.fromJson(json3, MonedaExchangeRate.class);
                    System.out.println("$" + (int) cantidad + " DOLARES" + " son " + "$" + moneda3.conversion_result() + " REALES BRASILEÑOS");
                    break;
                case 4:
                    System.out.println("Convirtiendo BRL a USD");
                    var json4 = api.CurrencyConverter("BRL", "USD", cantidad);
                    MonedaExchangeRate moneda4 = gson.fromJson(json4, MonedaExchangeRate.class);
                    System.out.println("$" + cantidad + " REALES BRASILEÑOS" + " son " + "$" + moneda4.conversion_result() + " DOLARES");
                    break;
                case 5:
                    System.out.println("Convirtiendo USD a COP");
                    var json5 = api.CurrencyConverter("USD", "COP", cantidad);
                    MonedaExchangeRate moneda5 = gson.fromJson(json5, MonedaExchangeRate.class);
                    System.out.println("$" + (int) cantidad + " DOLARES" + " son " + "$" + moneda5.conversion_result() + " PESOS COLOMBIANOS");
                    break;
                case 6:
                    System.out.println("Convirtiendo COP a USD");
                    var json6 = api.CurrencyConverter("COP", "USD", cantidad);
                    MonedaExchangeRate moneda6 = gson.fromJson(json6, MonedaExchangeRate.class);
                    System.out.println("$" + cantidad + " PESOS COLOMBIANOS" + " son " + "$" + moneda6.conversion_result() + " DOLARES");
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            //preguntar si desea hacer otra conversion
            System.out.println("Desea hacer otra conversión? (s/n)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n"))
            {
                System.exit(0);
            }
        }
    }
}