/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws.service;

import com.leonardo.conection.Conectate;
import com.leonardo.ws.dao.Alerta;
import com.leonardo.ws.dao.Mapa;
import com.leonardo.ws.dao.Ubicacion;
import com.leonardo.ws.util.Constantes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USUARIO
 */
@Path("/service/")
public class ServicioCore {
    private Conectate con = new Conectate();
    private List<Double> RangoX;
    private List<Double> RangoY;
    private final static Logger LOGGER = Logger.getLogger("com.leonardo.ws.ServicioCore");

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("obtenerMapa/")
    public Mapa obtenerMapa() {
        if (Constantes.SIMULADOR_MAPA) {
            return mapaSimulado();
        } else {
            return dataMapa();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("obtenerUbicaciones/")
    public List<Ubicacion> obtenerUbicaciones() {
        if (Constantes.SIMULADOR_UBICACIONES) {
            return dataSimulada();
        } else {
            return dataConector();
        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("listarAlertas/")
    public List<Alerta> obtenerListaAlertas(@QueryParam("fecha") String fecha) {
        LOGGER.info("Fecha de Busqueda:" + fecha);
        if (Constantes.SIMULADOR_ALERTAS) {
            return listaAlertasSimuladas(fecha);
        } else {
            return listarAlertas(fecha);
        }
    }
    
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("listarAlertas/")
    public List<Alerta> obtenerntoGanado(@QueryParam("fecha") String fecha) {
        LOGGER.info("Fecha de Busqueda:" + fecha);
        if (Constantes.SIMULADOR_ALERTAS) {
            return listaAlertasSimuladas(fecha);
        } else {
            return listarAlertas(fecha);
        }
    }

    public List<Ubicacion> dataSimulada() {
        List<Ubicacion> ubicaciones = new LinkedList<>();
        int valorEntero = (int) Math.floor(Math.random() * 4);
        LOGGER.info("valor: " + valorEntero);
        switch (valorEntero) {
            case 0:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.173109, -78.476614, 4, existeAlerta("Ganado 1", -7.173109, -78.476614)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.173161, -78.476727, 5, existeAlerta("Ganado 2", -7.173161, -78.476727)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.172898, -78.476665, 2, existeAlerta("Ganado 3", -7.172898, -78.476665)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172637, -78.476550, 1, existeAlerta("Ganado 4", -7.172637, -78.476550)));
                break;

            case 1:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.172680, -78.476612, 4, existeAlerta("Ganado 1", -7.172680, -78.476612)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.172677, -78.476770, 5, existeAlerta("Ganado 2", -7.172677, -78.476770)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.172587, -78.476975, 2, existeAlerta("Ganado 3", -7.172587, -78.476975)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172089, -78.477353, 1, existeAlerta("Ganado 4", -7.172089, -78.477353)));
                break;

            case 2:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.172036, -78.477511, 4, existeAlerta("Ganado 1", -7.172036, -78.477511)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.172898, -78.476665, 5, existeAlerta("Ganado 2", -7.172898, -78.476665)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.173109, -78.476614, 2, existeAlerta("Ganado 3", -7.173109, -78.476614)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.172587, -78.476975, 1, existeAlerta("Ganado 4", -7.172587, -78.476975)));
                break;

            case 3:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.171478, -78.479627, 4, existeAlerta("Ganado 1", -7.171478, -78.479627)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.171737, -78.480598, 5, existeAlerta("Ganado 2", -7.171737, -78.480598)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.171716, -78.479311, 2, existeAlerta("Ganado 3", -7.171716, -78.479311)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.171359, -78.479032, 1, existeAlerta("Ganado 4", -7.171359, -78.479032)));
                break;
        }

        LOGGER.info("Data de Ubicaciones Simuladas Exitosa");
        return ubicaciones;
    }

    private List<Ubicacion> dataConector() {
        //comunicacion con sensores
        return null;
    }

    private List<Alerta> listaAlertasSimuladas(String fecha) {
        List<Alerta> alertas = new LinkedList<>();
        alertas.add(new Alerta("Ganado 1", fecha + " 12:30:35 AM"));
        alertas.add(new Alerta("Ganado 2", fecha + " 01:30:35 PM"));
        alertas.add(new Alerta("Ganado 3", fecha + " 05:30:35 PM"));
        alertas.add(new Alerta("Ganado 3", fecha + " 12:30:35 PM"));

        LOGGER.info("Data de Alertas Simuladas Exitosa");
        LOGGER.info("Alertas " + alertas.toString());
        return alertas;
    }

    private List<Alerta> listarAlertas(String fecha) {
        try {
            ResultSet rs = con.consultarAlertaxGanado(fecha);
            List<Alerta> alertas = new LinkedList<>();
            while (rs.next()) {
                alertas.add(new Alerta(rs.getString(1), rs.getString(2)));
            }
            return alertas;
        } catch (SQLException ex) {
            Logger.getLogger(ServicioCore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<Alerta> alertaSimulada() {
        return null;
    }

    private List<Alerta> alerta() {
        return null;
    }

    private String existeAlerta(String nombreGanado, double posicionX, double posicionY) {
        if (!esUbicacionValida(posicionX, posicionY)) {
            return registrarAlerta(nombreGanado, posicionX, posicionY, new Date());
        }
        return null;
    }

    private Boolean esUbicacionValida(double posicionX, double posicionY) {
        //calcular posiscion invalida
        if (!dentroRango(posicionX, posicionY)) {
            return false;
        }
        return true;
    }

    private String registrarAlerta(String nombreGanado, double posicionX, double posicionY, Date fecha) {
        //guardarAlerta();
        //enviarAlerta();
        //enviar mensaje correo
        return mostrarFechaAlerta(fecha);
    }

    private String mostrarFechaAlerta(Date fechaActual) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/y hh:mm:ss a");
        LOGGER.info("Generando Alerta: " + formatoFecha.format(fechaActual));
        return formatoFecha.format(fechaActual);
    }

    private Mapa mapaSimulado() {
        LOGGER.info("Consumiendo Mapa");
        return new Mapa(18, -7.171757, -78.478472);
    }

    private Mapa dataMapa() {
        return null;
    }

    private boolean dentroRango(double posicionX, double posicionY) {
        RangoX = new ArrayList<Double>();
        RangoX.add(-7.170158); //cuadrante 1
        RangoX.add(-7.170339); //cuadrante 2
        RangoX.add(-7.173266); //cuadrante 3
        RangoX.add(-7.173138); //cuadrante 4
        RangoY = new ArrayList<Double>();
        RangoY.add(-78.476396); //cuadrante 1
        RangoY.add(-78.480571); //cuadrante 2
        RangoY.add(-78.480274); //cuadrante 3
        RangoY.add(-78.476348); //cuadrante 4
        
        for (int i = 0; i < RangoX.size(); i++) {
            if (posicionX < RangoX.get(i) &&  posicionY < RangoY.get(i)) {
                return false;
            }
        }
        return true;
    }
}
