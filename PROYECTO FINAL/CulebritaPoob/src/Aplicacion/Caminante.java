
package Aplicacion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Caminante implements Runnable{  
    Juego juego;
    boolean estado=true;
    int tiempo;
    boolean segundoJugador;
    
    public Caminante(Juego juego,boolean segundoJugador){
            this.juego=juego;
            tiempo=150;
            this.segundoJugador=segundoJugador;
    }
    
    @Override
    public void run() {
        while (estado) {
                    juego.repaint();
                    
                    Snake snake=juego.getSnake1();
                    
                   
                    juego.correr(snake);
                   if (segundoJugador) {
                    Snake snake2=juego.getSnake2();
                    juego.correr(snake2);
                   }
                  
                   
                    try {
                        Thread.sleep(tiempo);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
           }
    public void setSegundoJugador(){segundoJugador=true; }
    
    public void parar(){
        this.estado=false;
    }
    public void renudar(){
        this.estado=true;
    }
    public void setTiempo(int n ){
        tiempo=50;
    }

}
