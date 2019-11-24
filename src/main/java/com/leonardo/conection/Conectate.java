/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.conection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Conectate {

    private String driver = "com.mysql.jdbc.Driver";
    private String cadenaConeccion = "jdbc:mysql://127.0.0.1/ganado";
    private String usuario = "root";
    private String contraseña = "";
    public Connection con;
    private final static Logger LOGGER = Logger.getLogger("com.leonardo.conection.Conectate");

    public Connection Conectate() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(cadenaConeccion, usuario, contraseña);
            LOGGER.info("Conexion Exitosa");
        } catch (Exception ex) {
            LOGGER.info("Error de conexion: " + ex);
        }
        return con;
    }

    public ResultSet consultarAlertaxGanado(String fecha) {
        ResultSet rs = null;
        try {
            Conectate();
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM tp_alerta join tp_ganado on tp_ganado.id_ganado=tp_alerta.id_ganado");
        } catch (SQLException ex) {
            Logger.getLogger(Conectate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
