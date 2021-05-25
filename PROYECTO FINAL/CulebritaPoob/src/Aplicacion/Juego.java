
package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Presentacion.Informacion;

/**
 * @author Diego Macana, Natalia Orjuela 
 * Programacion Orientada Objetos 2021-1
 * Nuestro primer videojuego bonito 
 */

public class Juego extends JPanel {
    
    //Atributos de clase :
    
    //jugadores
    Snake snake;
    Snake snake2;
    
    Informacion info1;
    Informacion info2;
    
    Alimento comida;
    Arcoiris arco; 
    Dulce dulce;
    Veneno veneno;
    poder poder;
    
    boolean haypoder;
    
    int conta1;
    int conta2;
    int conta3;
    int conta4;
    Thread hilo;
    Caminante camino;
    boolean dosJugadores;
    
    
    //metodo 1 jugador
    public Juego(Snake snake, Informacion info1,Alimento comida,Arcoiris arco, Dulce dulce, Veneno veneno,poder poder){
                 this.snake=snake;
                 this.info1=info1;
                this.comida=comida;
                this.poder=poder;
                this.arco=arco;
                this.dulce=dulce;
                this.veneno=veneno;
                comida.generarComida();
                dosJugadores=false;
                conta1=1;
                conta2=1;
                conta3=1;
                conta4=1;
                camino=new Caminante(this,false);
                hilo = new Thread(camino);
                hilo.start();      
    }
    
     public Juego(Snake snake,Snake snake2, Informacion info1,Alimento comida,Arcoiris arco, Dulce dulce, Veneno veneno,poder poder){
                this(snake,info1,comida,arco,dulce,veneno,poder);
                 this.snake2=snake2;        
                 camino.setSegundoJugador();
                 dosJugadores=true;
    }
     
     public void colicionEntreSerpientes(int[] nuevo2){
         List<int[] > snk1=snake.getPosSnake();
         List<int[] > snk2=snake2.getPosSnake();
         
          for (int i=0;i<snk1.size();i++){
                    if ( snk1.get(i)[0]==nuevo2[0] && snk1.get(i)[1]==nuevo2[1] ){
                                     JOptionPane.showMessageDialog(null, "Has chocado! pierdes jugador 2"); 
                                     System.exit(0);
                            }
           }
          
           for (int i=0;i<snk2.size();i++){
                    if ( snk2.get(i)[0]==nuevo2[0] && snk2.get(i)[1]==nuevo2[1] ){
                                     JOptionPane.showMessageDialog(null, "Has chocado! pierdes jugador 1"); 
                                     System.exit(0);
                            }
           }
           
     }
    
    
    public void correr (Snake snake){
     int[] nuevo=snake.avanzar();
     
     if (dosJugadores){
         colicionEntreSerpientes(nuevo);
     }
     
     int[] comidaa=comida.getComida();
     int[] arcoiris=arco.getComida();
     int[] dulcee=dulce.getComida();
     int[] venenoo=veneno.getComida();
     int[]poderr=poder.getComida();
     
    
      if ( nuevo[0]==comidaa[0] && nuevo[1]==comidaa[1]  ){    //comida normal
                    snake.setSnake(nuevo);
                    invocarSorpresas();
                    comida.generarComida();
                    info1.setFruta(1);
                    
      }
      else if (nuevo[0]==arcoiris[0] && nuevo[1]==arcoiris[1]  ){     //comida arcoiris
                     for (int i=0;i<3;i++){snake.setSnake(nuevo); }
                     comida.generarComida();
                     info1.setArcoiris(1);    
                     info1.setFruta(3);
                     arco.cambiarPos(-1, -1);
                      

      }else if (nuevo[0]==venenoo[0] && nuevo[1]==venenoo[1]){ //VENENO
                     
                      JOptionPane.showMessageDialog(null, " Has perdido, tocaste el veneno :("); 
                      System.exit(0);
                      venenoo[0]=100;
                      venenoo[1]=100;
                      veneno.cambiarPos(-1, -1);

      }else if (nuevo[0]==dulcee[0] && nuevo[1]==dulcee[1]){    //DULCE
                      for (int i=0;i<3;i++){snake.setSnake2(0); }
                      comida.generarComida();
                      info1.setDulce(1);
                       info1.setFruta(-3);
                      dulce.cambiarPos(-1, -1);
                      
      } else if (nuevo[0]==poderr[0] && nuevo[1]==poderr[1]){   //poder
                      info1.setVeneno(); 
                      for (int i=0;i<2;i++){ snake.setSnake(nuevo); }
                       JOptionPane.showMessageDialog(null, " Has desbloqueado un poder!!! usa espacio para usarlo "); 
                      comida.generarComida();
                      info1.setFruta(2);
                      haypoder=true; 
                      poder.cambiarPos(-1, -1);
                      
      }else{
           snake.setSnake(nuevo); //agrega cabeza
           snake.setSnake2(0); //elimina cola
        }
      
 }
    
    private void invocarSorpresas(){
         if (conta1%5==0){
                  arco.generarComida();
                  comida.generarComida(); 
                  conta1=1;
              }else{
                     arco.cambiarPos(-1, -1);
                    }
            if (conta2%7==0){
               dulce.generarComida();
               comida.generarComida();
               conta2=1;
             }else{
                    dulce.cambiarPos(-1, -1);
            }
            if (conta3%10==0){
               veneno.generarComida();
               comida.generarComida();
               conta3=1;
             }else{
                    veneno.cambiarPos(-1, -1);
            }
            if (conta4%3==0){
               poder.generarComida();
               comida.generarComida();
               conta4=1;
             }else{
               poder.cambiarPos(-1, -1);
            }
            
          conta1=conta1+1;
          conta2=conta2+1;
          conta3=conta3+1;
          conta4=conta4+1;
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        int[] comidaa=comida.getComida();

        int tamc=snake.getTamC();
        int residuo=snake.getResiduo();
        
        
        pintor.setColor(snake.getColor());
        List<int[]> snakee =snake.getPosSnake();
        
        //pintar serpiente
        for (int[] sn:snakee){
            pintor.fillRect(residuo/2+ sn[0]*tamc ,residuo/2+sn[1]*tamc ,tamc-1,tamc-1);
        }
        //pinta serpiente 2
        if (dosJugadores){
                pintor.setColor(snake2.getColor());
                List<int[] > snk2=snake2.getPosSnake();
       
                  for (int[] sn:snk2){
                            pintor.fillRect(residuo/2+ sn[0]*tamc ,residuo/2+sn[1]*tamc ,tamc-1,tamc-1);
                    }
        }
        
          pintor.setColor(comida.getColor());
     
          pintor.fillRect(residuo/2+ comidaa[0]*tamc ,residuo/2+comidaa[1]*tamc ,tamc-1,tamc-1);
      
          int[] arcoiris=arco.getComida();
          pintor.setColor(arco.getColor());
          pintor.fillRect(residuo/2+ arcoiris[0]*tamc ,residuo/2+arcoiris[1]*tamc ,tamc-1,tamc-1);
       
           int[] dulcee=dulce.getComida();
           pintor.setColor(dulce.getColor());
           pintor.fillRect(residuo/2+ dulcee[0]*tamc ,residuo/2+dulcee[1]*tamc ,tamc-1,tamc-1);
       
           int[] venenoo=veneno.getComida();
           pintor.setColor(veneno.getColor());
           pintor.fillRect(residuo/2+ venenoo[0]*tamc ,residuo/2+venenoo[1]*tamc ,tamc-1,tamc-1);
       
           int[]poderr=poder.getComida();
           pintor.setColor(poder.getColor());
           pintor.fillRect(residuo/2+ poderr[0]*tamc ,residuo/2+poderr[1]*tamc ,tamc-1,tamc-1);

    }
    

        public void poder(){
            if (haypoder){
                    Color nuevo =new Color (153, 255, 0 );
                    snake.setColor(nuevo);
                    camino.setTiempo(90);
                    haypoder=false;
                    
            }
        }
        
       public void pausar(){
        camino.parar();
    }
    public void renudar(){
        camino.renudar();
        hilo = new Thread(camino);
        hilo.start();
    }
    
    public Snake getSnake1(){
        return snake;
        }
    public Snake getSnake2(){
        return snake2;
        }

}
