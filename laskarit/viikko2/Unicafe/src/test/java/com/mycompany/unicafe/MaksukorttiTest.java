package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Kassapaate kassa;
    Paaohjelma p;
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        kassa = new Kassapaate();
        p = new Paaohjelma();
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test 
    public void hello() {}
    
    
    
    @Test
    public void saldoOnOikein() {
        
        assertEquals("saldo: 10.0", kortti.toString());
        
    }
    @Test
    public void lisaysToimii() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 20.0", kortti.toString());
        
    }
    @Test
    public void edullisestiOikein() {
        kassa.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
        
    }
    @Test
    public void maukkaastiOikein() {
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 6.0", kortti.toString());
        
    }
    @Test
    public void vahennysOnOikein() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 2.0", kortti.toString());
        
    }
    
    @Test
    public void vahennysEdOikein() {
        kassa.syoEdullisesti(12);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void testEd() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(240);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(40, kortti.saldo());
        
        
    }
    
    @Test
    public void testMau() {
        kassa.syoMaukkaasti(900);
        kassa.syoMaukkaasti(200);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void testStats() {
        kassa.maukkaitaLounaitaMyyty();
        kassa.edullisiaLounaitaMyyty();
    }
    
    @Test
    public void latausToimiiKortille() {
        kassa.lataaRahaaKortille(kortti, 10);
        assertEquals(2000, kortti.saldo());
        
        
    }
    
    @Test
    public void latausEiToimiNeg() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test 
    public void palautusmuotoOikein() {
        
        kassa.syoMaukkaasti(kortti);
        assertEquals(true, kassa.syoMaukkaasti(kortti));
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void rahaVaheneeOikein() {
        kortti.otaRahaa(1100);
        assertEquals(1000, kortti.saldo());
    }
   
    
   
}
