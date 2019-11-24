/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonardo.conection;

import java.sql.ResultSet;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author USUARIO
 */
public class ConectateTest {
    @Test
    public void probarConexion(){
        Conectate con = new Conectate();
        Assert.assertNotNull(con);
    }
    
    @Test
    public void consultarAlertaxGanadoTest(){
        Conectate con = new Conectate();
        ResultSet rs = con.consultarAlertaxGanado("a");
        Assert.assertNotNull(rs);
    }
}
