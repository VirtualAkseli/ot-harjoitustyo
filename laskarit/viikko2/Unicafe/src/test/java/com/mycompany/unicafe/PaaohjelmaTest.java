/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aknu
 */
public class PaaohjelmaTest {
    
    public PaaohjelmaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMain() {
        
        String[] args = new String[2];
       Paaohjelma.main(new String[2]);
      
        
    }

    @Test
    public void testToString() {
       
        Paaohjelma instance = new Paaohjelma();
        String expResult = "Täällä ollaan!";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
