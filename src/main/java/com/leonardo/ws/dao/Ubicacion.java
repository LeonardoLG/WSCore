/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws.dao;

/**
 *
 * @author lleon
 */
public class Ubicacion {
    private String nombreGanado;
    private double lat;
    private double lng;
    private int zIndex;
    private String fechaAlerta;

    public Ubicacion(String nombreGanado, double lat, double lng, int zIndex, String fechaAlerta) {
        this.nombreGanado = nombreGanado;
        this.lat = lat;
        this.lng = lng;
        this.zIndex = zIndex;
        this.fechaAlerta = fechaAlerta;
    }

    public String getNombreGanado() {
        return nombreGanado;
    }

    public void setNombreGanado(String nombreGanado) {
        this.nombreGanado = nombreGanado;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public String getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(String fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "nombreGanado=" + nombreGanado + ", lat=" + lat + ", lng=" + lng + ", zIndex=" + zIndex + ", fechaAlerta=" + fechaAlerta + '}';
    }
    
    

}
