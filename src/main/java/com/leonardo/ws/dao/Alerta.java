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
    private Date fechaAlerta;

    public Alerta(String nombreGanado, Date fechaAlerta) {
        this.nombreGanado = nombreGanado;
        this.fechaAlerta = fechaAlerta;
    }

    public String getNombreGanado() {
        return nombreGanado;
    }

    public void setNombreGanado(String nombreGanado) {
        this.nombreGanado = nombreGanado;
    }

    public Date getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(Date fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    @Override
    public String toString() {
        return "Alerta{" + "nombreGanado=" + nombreGanado + ", fechaAlerta=" + fechaAlerta + '}';
    }

}
