/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.ws.service;

import com.leonardo.conection.SMSSender;
import com.leonardo.conection.Conectate;
import com.leonardo.ws.dao.Alerta;
import com.leonardo.ws.dao.Mapa;
import com.leonardo.ws.dao.Ubicacion;
import com.leonardo.ws.util.Constantes;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
            return obtenerUbicacionesSimuladas();
        } else {
            return dataConector();
        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("listarAlertas/")
    public List<Alerta> obtenerListaAlertas(@QueryParam("fecha") String fecha) {
        LOGGER.log(Level.INFO, "Fecha de Busqueda:{0}", fecha);
        if (Constantes.SIMULADOR_ALERTAS) {
            return listaAlertasSimuladas(fecha);
        } else {
            return listarAlertas(fecha);
        }
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("listarCaminoGanado/")
    public List<Ubicacion> obtenerCaminoGanado(@QueryParam("ganado") String ganado, @QueryParam("fecha") String fecha) {
        LOGGER.info("Ganado y Fecha de Busqueda del Camino: " + ganado + " " + fecha);
        if (Constantes.SIMULADOR_CAMINO) {
            return listarCaminoSimulado(ganado, fecha);
        } else {
            return listarCamino(ganado, fecha);
        }
    }

    public List<Ubicacion> obtenerUbicacionesSimuladas() {
        List<Ubicacion> ubicaciones = new LinkedList<>();
        int valorEntero = (int) Math.floor(Math.random() * 5);
        LOGGER.log(Level.INFO, "valor: {0}", valorEntero);
        switch (valorEntero) {
            case 0:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.161791, -78.473983, 4, existeAlerta("Ganado 1", -7.161791, -78.473983)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.161956, -78.474031, 5, existeAlerta("Ganado 2", -7.161956, -78.474031)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.162355, -78.473999, 2, existeAlerta("Ganado 3", -7.162355, -78.473999)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.162467, -78.474061, 1, existeAlerta("Ganado 4", -7.162467, -78.474061)));
                break;

            case 1:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.162488, -78.473119, 4, existeAlerta("Ganado 1", -7.162488, -78.473119)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.162626, -78.473709, 5, existeAlerta("Ganado 2", -7.162626, -78.473709)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.162280, -78.473001, 2, existeAlerta("Ganado 3", -7.162280, -78.473001)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.161993, -78.472899, 1, existeAlerta("Ganado 4", -7.161993, -78.472899)));
                break;

            case 2:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.162500, -78.472735, 4, existeAlerta("Ganado 1", -7.162500, -78.472735)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.162835, -78.473347, 5, existeAlerta("Ganado 2", -7.162835, -78.473347)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.163203, -78.473878, 2, existeAlerta("Ganado 3", -7.163203, -78.473878)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.161758, -78.471346, 1, existeAlerta("Ganado 4", -7.161758, -78.471346)));
                break;

            case 3:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.162759, -78.472652, 4, existeAlerta("Ganado 1", -7.162759, -78.472652)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.163111, -78.473964, 5, existeAlerta("Ganado 2", -7.163111, -78.473964)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.163340, -78.473832, 2, existeAlerta("Ganado 3", -7.163340, -78.473832)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.163164, -78.473398, 1, existeAlerta("Ganado 4", -7.163164, -78.473398)));
                break;

            case 4:
                ubicaciones.add(new Ubicacion("Ganado 1", -7.163217, -78.471113, 4, existeAlerta("Ganado 1", -7.163217, -78.471113)));
                ubicaciones.add(new Ubicacion("Ganado 2", -7.163819, -78.471654, 5, existeAlerta("Ganado 2", -7.163819, -78.471654)));
                ubicaciones.add(new Ubicacion("Ganado 3", -7.161876, -78.471413, 2, existeAlerta("Ganado 3", -7.161876, -78.471413)));
                ubicaciones.add(new Ubicacion("Ganado 4", -7.162610, -78.472835, 1, existeAlerta("Ganado 4", -7.162610, -78.472835)));
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
        alertas.add(new Alerta("Ganado 1", fecha + " 12:30:35 AM", -7.163217, -78.471113));
        alertas.add(new Alerta("Ganado 2", fecha + " 01:30:35 PM", -7.163819, -78.471654));
        alertas.add(new Alerta("Ganado 3", fecha + " 05:30:35 PM", -7.161876, -78.471413));

        LOGGER.info("Data de Alertas Simuladas Exitosa");
        return alertas;
    }

    private List<Alerta> listarAlertas(String fecha) {
        try {
            ResultSet rs = con.consultarAlertaxGanado(fecha);
            List<Alerta> alertas = new LinkedList<>();
            while (rs.next()) {
                alertas.add(new Alerta(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(4))));
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
        //calcular posicion invalida
        if (!dentroRango(posicionX, posicionY)) {
            return false;
        }
        return true;
    }

    private String registrarAlerta(String nombreGanado, double posicionX, double posicionY, Date fecha) {
        //guardarAlerta();
        //enviarAlerta();
        enviarAlerta(nombreGanado, fecha, posicionX, posicionY);
        return mostrarFechaAlerta(fecha);
    }

    private String mostrarFechaAlerta(Date fechaActual) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/y hh:mm:ss a");
        LOGGER.log(Level.INFO, "Generando Alerta: {0}", formatoFecha.format(fechaActual));
        return formatoFecha.format(fechaActual);
    }

    private Mapa mapaSimulado() {
        LOGGER.info("Consumiendo Mapa");
        return new Mapa(18, -7.162959, -78.472325);
    }

    private Mapa dataMapa() {
        return null;
    }

    private boolean dentroRango(double posicionX, double posicionY) {
        RangoX = new ArrayList<Double>();
        RangoX.add(-7.161519); //cuadrante 1
        RangoX.add(-7.161679); //cuadrante 2
        RangoX.add(-7.163851); //cuadrante 3
        RangoX.add(-7.163962); //cuadrante 4
        RangoY = new ArrayList<Double>();
        RangoY.add(-78.472143); //cuadrante 1
        RangoY.add(-78.474063); //cuadrante 2
        RangoY.add(-78.474476); //cuadrante 3
        RangoY.add(-78.472529); //cuadrante 4
        LOGGER.info("Ganado: " + posicionX + posicionY);
        if (posicionX < RangoX.get(0) && posicionY > RangoY.get(0)) {
            LOGGER.info("Fuera del cuadrante 1: " + RangoX.get(0) + RangoY.get(0));
            return false;
        }

        if (posicionX < RangoX.get(1) && posicionY < RangoY.get(1)) {
            LOGGER.info("Fuera del cuadrante 2: " + RangoX.get(1) + RangoY.get(1));
            return false;
        }

        if (posicionX > RangoX.get(2) && posicionY < RangoY.get(2)) {
            LOGGER.info("Fuera del cuadrante 3: " + RangoX.get(2) + RangoY.get(2));
            return false;
        }

        if (posicionX > RangoX.get(3) && posicionY > RangoY.get(3)) {
            LOGGER.info("Fuera del cuadrante 4: " + RangoX.get(3) + RangoY.get(3));
            return false;
        }

        return true;
    }

    private List<Ubicacion> listarCaminoSimulado(String ganado, String fecha) {
        List<Ubicacion> ubicaciones = new LinkedList<>();
        switch (ganado) {
            case "Ganado 1":
                ubicaciones.add(new Ubicacion(ganado, -7.163566, -78.473975, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163513, -78.473819, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163598, -78.473621, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163641, -78.473449, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163683, -78.473208, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163688, -78.473095, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163571, -78.472945, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163295, -78.472945, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162981, -78.472993, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162682, -78.473138, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162528, -78.473122, 4, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162289, -78.473052, 4, fecha));
                break;
            case "Ganado 2":
                ubicaciones.add(new Ubicacion(ganado, -7.161873, -78.473857, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162017, -78.473798, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162193, -78.473862, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162384, -78.473916, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162539, -78.473819, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162555, -78.473648, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162640, -78.473492, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162816, -78.473331, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162917, -78.473208, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163124, -78.473262, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163135, -78.473101, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163332, -78.472988, 5, fecha));
                break;
            default:
                ubicaciones.add(new Ubicacion(ganado, -7.161873, -78.473857, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162017, -78.473798, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162193, -78.473862, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162384, -78.473916, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162539, -78.473819, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162555, -78.473648, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162640, -78.473492, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162816, -78.473331, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.162917, -78.473208, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163124, -78.473262, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163135, -78.473101, 5, fecha));
                ubicaciones.add(new Ubicacion(ganado, -7.163332, -78.472988, 5, fecha));
                break;
        }
        return ubicaciones;
    }

    private List<Ubicacion> listarCamino(String ganado, String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void enviarAlerta(String nombreGanado, Date fecha, double posicionX, double posicionY) {
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String mensaje = "El " + nombreGanado + " esta fuera de la zona segura. "
                + "Posicion Actual (" + posicionX + ", " + posicionY + "). "
                + "Fecha y Hora: " + hourdateFormat.format(fecha) + " URL: https://maps.google.com/?q=" + posicionX + "," + posicionY + "&z=24&t=h";
        SMSSender conectorSMS = new SMSSender(mensaje, Constantes.PHONE_NUMBER, Constantes.USER_SMS, Constantes.PASS_SMS, Constantes.ADDRESS, Constantes.PORT);
        try {
            conectorSMS.enviarSMS();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServicioCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioCore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
