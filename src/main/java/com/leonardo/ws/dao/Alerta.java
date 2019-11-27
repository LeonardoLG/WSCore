/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws.dao;

import java.util.Date;

/**
 *
 * @author lleon
 */
public class Alerta {

    private String nombreGanado;
    private String fechaAlerta;
    private double lat;
    private double lon;

    public Alerta(String nombreGanado, String fechaAlerta, double lat, double lon) {
        this.nombreGanado = nombreGanado;
        this.fechaAlerta = fechaAlerta;
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getNombreGanado() {
        return nombreGanado;
    }

    public void setNombreGanado(String nombreGanado) {
        this.nombreGanado = nombreGanado;
    }

    public String getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(String fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    
    
}
