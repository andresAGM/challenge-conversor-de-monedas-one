package com.conversordemonedas.model;

public class Moneda
{
    private String resultado;
    private String horaUltimaActualizacion;
    private String monedaBase;
    private String monedaObjetivo;
    private double tasaCambio;
    private double cantidadConvertida;

    public Moneda(String resultado, String horaUltimaActualizacion, String monedaBase, String monedaObjetivo, double tasaCambio, double cantidadConvertida)
    {
        this.resultado = resultado;
        this.horaUltimaActualizacion = horaUltimaActualizacion;
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.tasaCambio = tasaCambio;
        this.cantidadConvertida = cantidadConvertida;
    }

    public String getResultado()
    {
        return resultado;
    }

    public String getHoraUltimaActualizacion()
    {
        return horaUltimaActualizacion;
    }

    public String getMonedaBase()
    {
        return monedaBase;
    }

    public String getMonedaObjetivo()
    {
        return monedaObjetivo;
    }

    public double getTasaCambio()
    {
        return tasaCambio;
    }

    public double getCantidadConvertida()
    {
        return cantidadConvertida;
    }
}
