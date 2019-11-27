/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.conection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class SMSSender {

    private final static Logger LOGGER = Logger.getLogger("com.leonardo.conection.SMSSender");
    
    private String message;
    private String phone;
    private String username;
    private String password;
    private String address;
    private String port;
    
    public SMSSender(String message, String phone, String username, String password, String address, String port) {
        this.message = message;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.address = address;
        this.port = port;
    }
    
    public void enviarSMS() throws MalformedURLException, UnsupportedEncodingException, IOException {
        String enlace = this.address + ":" + this.port + "/SendSMS?username=" + this.username
                + "&password=" + this.password + "&phone=" + this.phone + "&message=" + URLEncoder.encode(this.message, "UTF-8");
        LOGGER.log(Level.INFO, "Enlace a enviar: {0}", enlace);
        URL url = new URL(enlace);
        URLConnection connection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            System.out.println(inputLine);
        }
        bufferedReader.close();
    }    
}
