package com.conversordemonedas.main;

import com.conversordemonedas.model.ApiMonedasExchangeRate;

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
            //sino esta esta condicion en caso de elegir el 7 no sale del sistema
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
            * *
            * Luego mostramos el resultado de la conversion
            * */
            ApiMonedasExchangeRate apiMonedasExchangeRate = new ApiMonedasExchangeRate();
            switch (opcion)
            {
                case 1:
                    System.out.println("Convirtiendo USD a ARS");
                    System.out.print("$" + (int) cantidad + " ");
                    apiMonedasExchangeRate.CurrencyConverter("USD", "ARS", cantidad);
                    System.out.println(" PESOS ARGENTINOS");
                    break;
                case 2:
                    System.out.println("Convirtiendo ARS a USD");
                    System.out.print("$" + cantidad + " ");
                    apiMonedasExchangeRate.CurrencyConverter("ARS", "USD", cantidad);
                    System.out.println(" DOLARES");
                    break;
                case 3:
                    System.out.println("Convirtiendo USD a BRL");
                    System.out.print("$" + (int) cantidad + " ");
                    apiMonedasExchangeRate.CurrencyConverter("USD", "BRL", cantidad);
                    System.out.println(" REAIS");
                    break;
                case 4:
                    System.out.println("Convirtiendo BRL a USD");
                    System.out.print("$" + cantidad + " ");
                    apiMonedasExchangeRate.CurrencyConverter("BRL", "USD", cantidad);
                    System.out.println(" DOLARES");
                    break;
                case 5:
                    System.out.println("Convirtiendo USD a COP");
                    System.out.print("$" + (int) cantidad + " ");
                    apiMonedasExchangeRate.CurrencyConverter("USD", "COP", cantidad);
                    System.out.println(" PESOS COLOMBIANOS");
                    break;
                case 6:
                    System.out.println("Convirtiendo COP a USD");
                    System.out.print("$" + cantidad + " ");
                    apiMonedasExchangeRate.CurrencyConverter("COP", "USD", cantidad);
                    System.out.println(" DOLARES");
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