/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws.dao;

/**
 *
 * @author USUARIO
 */
public class Mapa {
    private double zoom;
    private double lat;
    private double lon;

    public Mapa(double zoom, double lat, double lon) {
        this.zoom = zoom;
        this.lat = lat;
        this.lon = lon;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
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
    
}
