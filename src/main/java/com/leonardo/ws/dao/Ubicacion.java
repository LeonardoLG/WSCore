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
    private String title;
    private double lat;
    private double lng;
    private int zIndex;
    private int flagAlerta;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Ubicacion(String title, double lat, double lng, int zIndex, int flagAlerta) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
        this.zIndex = zIndex;
        this.flagAlerta = flagAlerta;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "title=" + title + ", lat=" + lat + ", lng=" + lng + ", zIndex=" + zIndex + '}';
    }
    
}
