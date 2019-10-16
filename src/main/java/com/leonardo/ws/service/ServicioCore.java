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
    @Path("ubicaciones/")
    public List<Ubicacion> obtenerUbicaciones() {
        if (Constantes.SIMULADOR_UBICACIONES) {
            return dataSimulada();
        } else {
            return dataConector();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @PathParam(String nombreGanado)
    @Path("alertas/")
    public List<Alerta> obtenerAlertas() {
        if (Constantes.SIMULADOR_ALERTAS) {
            return alertaSimulada();
        } else {
            return alerta();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("listaAlertas/")
    public List<Alerta> obtenerListaAlertas() {
        if (Constantes.SIMULADOR_ALERTAS) {
            return listaAlertasSimuladas();
        } else {
            return listarAlertas();
        }
    }

    public List<Ubicacion> dataSimulada() {
        List<Ubicacion> ubicaciones = new LinkedList<>();
        int valorEntero = (int) Math.floor(Math.random() * 3 + 0);

        switch (valorEntero) {
            case 0:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.173109, -78.476614, 4, generarAlerta("Ganado 1", -7.173109, -78.476614)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.173161, -78.476727, 5, generarAlerta("Ganado 2", -7.173161, -78.476727)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.172898, -78.476665, 2, generarAlerta("Ganado 3", -7.172898, -78.476665)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172637, -78.476550, 1, generarAlerta("Ganado 4", -7.172637, -78.476550)));
                break;

            case 1:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.172680, -78.476612, 4, generarAlerta("Ganado 1", -7.172680, -78.476612)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.172677, -78.476770, 5, generarAlerta("Ganado 2", -7.172677, -78.476770)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.172587, -78.476975, 2, generarAlerta("Ganado 3", -7.172587, -78.476975)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172089, -78.477353, 1, generarAlerta("Ganado 4", -7.172089, -78.477353)));
                break;

            case 2:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.172036, -78.477511, 4, generarAlerta("Ganado 1", -7.172036, -78.477511)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.172898, -78.476665, 5, generarAlerta("Ganado 2", -7.172898, -78.476665)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.173109, -78.476614, 2, generarAlerta("Ganado 3", -7.173109, -78.476614)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172587, -78.476975, 1, generarAlerta("Ganado 4", -7.172587, -78.476975)));
                break;

        }

        LOGGER.info("Data de Ubicaciones Simuladas Exitosa");
        return ubicaciones;
    }

    private List<Ubicacion> dataConector() {
        //comunicacion con sensores
        return null;
    }

    private List<Alerta> listaAlertasSimuladas() {
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

    private List<Alerta> listarAlertas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Alerta> alertaSimulada() {
        return null;
    }
    
    private List<Alerta> alerta() {
        return null;
    }
    
    private int generarAlerta(String nombreGanado, double posicionX, double posicionY) {
        if (!isUbicacionValida(posicionX, posicionY)){
            enviarAlerta(nombreGanado, posicionX, posicionY, new Date());
            return 1;
        }
        return 0;
    }
    
    private Boolean isUbicacionValida(double posicionX, double posicionY){
        //calcular posiscion invalida        
        return true;
    }
    
    private void enviarAlerta(String nombreGanado, double posicionX, double posicionY, Date fecha){
    //enviar mensaje correo    
    }
}
