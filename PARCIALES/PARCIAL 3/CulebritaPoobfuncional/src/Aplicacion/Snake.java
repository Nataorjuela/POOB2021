
package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Snake extends Elemento {
   

    public Snake(int tamp,int cantidad,Alimento ali,Informacion info,Arcoiris arco,Dulce dulce,Veneno veneno){
        super();
        super.veneno=veneno;
        super.dulce=dulce;
        super.arco=arco;
        super. info=info;
        super.ali=ali;
        super.tamp=tamp;
        super.cantidad=cantidad;
        tamc=tamp/cantidad;
        residuo=tamp%cantidad;
        conta=1;       
        conta2=1;
        conta3=1;
        camino=new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();
    }
    
    public void empezarEn(int aa, int bb){
         int [] a={bb,bb};
        int [] b={aa,aa};
        snake.add(a);
        snake.add(b);
    
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        int[] comida=ali.getComida();
        int[] arcoiris=arco.getComida();
        int[] dulcee=dulce.getComida();
        int[] venenoo=veneno.getComida();
        
        pintor.setColor(colorSnake);
        //pintar serpiente
        for (int[] sn:snake){
            pintor.fillRect(residuo/2+ sn[0]*tamc ,residuo/2+sn[1]*tamc ,tamc-1,tamc-1);
        }
       
      pintor.setColor(ali.getColor());
     
      pintor.fillRect(residuo/2+ comida[0]*tamc ,residuo/2+comida[1]*tamc ,tamc-1,tamc-1);
       if (conta%5==0){
        pintor.setColor(arco.getColor());
        pintor.fillRect(residuo/2+ arcoiris[0]*tamc ,residuo/2+arcoiris[1]*tamc ,tamc-1,tamc-1);}
       
       if (conta2%7==0){
           pintor.setColor(dulce.getColor());
           pintor.fillRect(residuo/2+ dulcee[0]*tamc ,residuo/2+dulcee[1]*tamc ,tamc-1,tamc-1);}
       
         if (conta3%10==0){
           info.advertencia();
           pintor.setColor(veneno.getColor());
           pintor.fillRect(residuo/2+ venenoo[0]*tamc ,residuo/2+venenoo[1]*tamc ,tamc-1,tamc-1);}
    }
    
    public void avanzar (){
    igualarDir();   
    
    int[] comida=ali.getComida();
     int[] arcoiris=arco.getComida();
     int[] dulcee=dulce.getComida();
      int[] venenoo=veneno.getComida();
     
    int[] ultimo =snake.get(snake.size()-1);
    int agregarx=0;
    int agregary=0;
    
    switch (direccion){
            case "de":agregarx=1;break;
            case "iz":agregarx=-1;break;
            case "ar":agregary=-1;break;
            case "ab":agregary=1;break;
        }
        int [] nuevo ={ Math.floorMod(ultimo[0]+agregarx,cantidad) ,Math.floorMod(ultimo[1]+agregary,cantidad)};
    
        boolean existe=false;
        for (int i = 0; i < snake.size(); i++) {
            if (nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
                existe=true;
                break;
            }
            }
           //va a chocar
          if (existe){
              JOptionPane.showMessageDialog(null, "Has perdido");
              System.exit(0); 
          }else{
              if ( nuevo[0]==comida[0] && nuevo[1]==comida[1]  ){
                     snake.add(nuevo); 
                      if (conta%5==0){
                          arco.generarComida();
                          conta=1;
                          ali.generarComida(); 
                      }
                      else  if (conta2%7==0){
                          dulce.generarComida();
                          conta2=1;
                           ali.generarComida();
                         }
                       else  if (conta3%10==0){
                           
                           veneno.generarComida();
                           
                           conta3=1;
                           ali.generarComida();
                         }
                      else{
                          ali.generarComida();
                           conta=conta+1;
                           conta2=conta2+1;
                           conta3=conta3+1;
                           }
                     
                         info.setFruta(1);
              }else if (nuevo[0]==arcoiris[0] && nuevo[1]==arcoiris[1]  ){
                             for (int i=0;i<2;i++){snake.add(nuevo); }
                             ali.generarComida();
                             info.setArcoiris(1);    
                             info.setFruta(3);
                             
                              arcoiris[0]=100;
                              arcoiris[1]=100;
                              
              }else if (nuevo[0]==venenoo[0] && nuevo[1]==venenoo[1]){
                               info.setVeneno(); 
                               JOptionPane.showMessageDialog(null, " Has perdido"); 
                              System.exit(0);
                              venenoo[0]=100;
                              venenoo[1]=100;
              
              }else{
                    snake.add(nuevo);
                    snake.remove(0);
                }
         }
    }

    

    public void cambiarDireccion (String dir){
        if ( (this.direccion.equals("de") || this.direccion.equals("iz")) && (dir.equals("ar") || dir.equals("ab")) ){
             this.direccionProxima=dir; }
        if ( (this.direccion.equals("ar") || this.direccion.equals("ab")) && (dir.equals("iz") || dir.equals("de")) ){
             this.direccionProxima=dir; }
         }
    
    public void pausar(){
        camino.parar();
    }
    public void renudar(){
        camino.renudar();
        hilo = new Thread(camino);
        hilo.start();
    }
            
    public void igualarDir(){
        this.direccion=this.direccionProxima;
         }
    
    public  List<int[] > getPosSnake(){
        return snake;
    }
    
    public void setcolorSnake (Color color){
        this.colorSnake=color;
        }
   
}