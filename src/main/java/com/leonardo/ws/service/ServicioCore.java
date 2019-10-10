/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws.service;

import com.leonardo.ws.dao.Alerta;
import com.leonardo.ws.dao.Ubicacion;
import com.leonardo.ws.util.Constantes;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USUARIO
 */
@Path("/service/")
public class ServicioCore {

    private final static Logger LOGGER = Logger.getLogger("com.leonardo.ws.ServicioCore");

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Ubicacion> obtenerUbicaciones() {
        if (Constantes.SIMULADOR_UBICACIONES) {
            return dataSimulada();
        } else {
            return dataConector();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{fecha}")
    public List<Alerta> obtenerAlertas(@PathParam("fecha") Date fecha) {
        if (Constantes.SIMULADOR_ALERTAS) {
            return alertaSimulada(fecha);
        } else {
            return listarAlertas(fecha);
        }
    }

    public List<Ubicacion> dataSimulada() {
        List<Ubicacion> ubicaciones = new LinkedList<>();
        int valorEntero = (int) Math.floor(Math.random() * 3 + 0);

        switch (valorEntero) {
            case 0:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.173109, -78.476614, 4));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.173161, -78.476727, 5));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.172898, -78.476665, 2));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172637, -78.476550, 1));
                break;

            case 1:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.172680, -78.476612, 4));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.172677, -78.476770, 5));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.172587, -78.476975, 2));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172089, -78.477353, 1));
                break;

            case 2:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.172036, -78.477511, 4));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.172898, -78.476665, 5));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.173109, -78.476614, 2));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172587, -78.476975, 1));
                break;

        }

        LOGGER.info("Data de Ubicaciones Simuladas Exitosa");
        return ubicaciones;
    }

    private List<Ubicacion> dataConector() {
        //comunicacion con sensores
        return null;
    }

    private List<Alerta> alertaSimulada(Date fecha) {
        List<Alerta> alertas = new LinkedList<>();
        Date fechaActual = new Date();
        alertas.add(new Alerta("Ganado 3", new Date(fechaActual.getTime() + TimeUnit.DAYS.toMillis(1))));
        alertas.add(new Alerta("Ganado 1", new Date(fechaActual.getTime() + TimeUnit.DAYS.toMillis(-1))));
        alertas.add(new Alerta("Ganado 4", new Date(fechaActual.getTime() + TimeUnit.DAYS.toMillis(-2))));
        alertas.add(new Alerta("Ganado 3", new Date(fechaActual.getTime() + TimeUnit.DAYS.toMillis(-3))));

        LOGGER.info("Data de Alertas Simuladas Exitosa");
        LOGGER.info("Alertas " + alertas);
        return alertas;
    }

    private List<Alerta> listarAlertas(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
