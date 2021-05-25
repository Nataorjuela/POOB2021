/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Caminante implements Runnable{  
    Snake snake;
    boolean estado=true;
    
    public Caminante(Snake snake ){
            this.snake=snake;
    }
    
    @Override
    public void run() {
    	  int cont = 0;
          while (estado) {
              snake.avanzar();
              if(cont == 10) {
                  cont = 0;
                  snake.ali.generarComida();
              }
              cont +=1;
              snake.repaint();
              try {
                  Thread.sleep(150);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
              }

          }
           }
    
    public void parar(){
        this.estado=false;
    }
    public void renudar(){
        this.estado=true;
    }
    
    
    
}
