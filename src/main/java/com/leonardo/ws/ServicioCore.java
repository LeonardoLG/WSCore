/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
        List<Ubicacion> prueba = new LinkedList<>();
        int valorEntero = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);

        switch (valorEntero) {
            case 0:
                prueba.add(new Ubicacion("Ganado 1", -7.173109, -78.476614, 4));
                prueba.add(new Ubicacion("Ganado 2", -7.173161, -78.476727, 5));
                prueba.add(new Ubicacion("Ganado 3", -7.172898, -78.476665, 2));
                prueba.add(new Ubicacion("Ganado 4", -7.172637, -78.476550, 1));
                break;

            case 1:
                prueba.add(new Ubicacion("Ganado 1", -7.172680, -78.476612, 4));
                prueba.add(new Ubicacion("Ganado 2", -7.172677, -78.476770, 5));
                prueba.add(new Ubicacion("Ganado 3", -7.172587, -78.476975, 2));
                prueba.add(new Ubicacion("Ganado 4", -7.172089, -78.477353, 1));
                break;

            case 2:
                prueba.add(new Ubicacion("Ganado 1", -7.172036, -78.477511, 4));
                prueba.add(new Ubicacion("Ganado 2", -7.172898, -78.476665, 5));
                prueba.add(new Ubicacion("Ganado 3", -7.173109, -78.476614, 2));
                prueba.add(new Ubicacion("Ganado 4", -7.172587, -78.476975, 1));
                break;

        }
        LOGGER.info("Consumo Exitoso");
        return prueba;
    }
}
