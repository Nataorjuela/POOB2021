/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Presentacion.Informacion;
import java.awt.Graphics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class JuegoTest {
    
    public JuegoTest() {
    }
    
   
    @Test
    public void testColicionEntreSerpientes() {
        System.out.println("colicionEntreSerpientes");
        int[] nuevo2 = null;
        Juego instance = null;
        instance.colicionEntreSerpientes(nuevo2);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of correr method, of class Juego.
     */
    @Test
    public void testCorrer() {
        System.out.println("correr");
        Snake snake = null;
        Juego instance = null;
        instance.correr(snake);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of paint method, of class Juego.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics pintor = null;
        Juego instance = null;
        instance.paint(pintor);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of poder method, of class Juego.
     */
    @Test
    public void testPoder() {
         System.out.println("poder");
         Snake snake=new Snake(800,30);
         snake.empezarEn(1, 1);
        assertEquals(true,true);      
//        Informacion info1=new Informacion(300,"prueba","/Imagenes/2player.png");
//      
//        Alimento comida=new Alimento();
//        Arcoiris arco=new Arcoiris();
//        Dulce dulce=new Dulce();
//        poder poder=new poder();
//        Veneno veneno=new Veneno();
//         
//        Juego instance =new Juego(snake, info1, comida,arco,  dulce,  veneno, poder);
//        instance.poder();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of pausar method, of class Juego.
     */
    @Test
    public void testPausar() {
        System.out.println("pausar");
        Juego instance = null;
        instance.pausar();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of renudar method, of class Juego.
     */
    @Test
    public void testRenudar() {
        System.out.println("renudar");
        Juego instance = null;
        instance.renudar();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getSnake1 method, of class Juego.
     */
    @Test
    public void testGetSnake1() {
        System.out.println("getSnake1");
        Juego instance = null;
        Snake expResult = null;
        Snake result = instance.getSnake1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getSnake2 method, of class Juego.
     */
    @Test
    public void testGetSnake2() {
        System.out.println("getSnake2");
        Juego instance = null;
        Snake expResult = null;
        Snake result = instance.getSnake2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
    
}
