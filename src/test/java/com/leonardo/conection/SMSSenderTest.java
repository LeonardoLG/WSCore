/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.conection;

import com.leonardo.ws.util.Constantes;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author USUARIO
 */
public class SMSSenderTest {
     @Test
    public void probarConexion(){
        SMSSender conectorSMS = new SMSSender("Hola", Constantes.PHONE_NUMBER, Constantes.USER_SMS, Constantes.PASS_SMS, Constantes.ADDRESS, Constantes.PORT);
         try {
             conectorSMS.enviarSMS();
         } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(SMSSenderTest.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(SMSSenderTest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    
}
