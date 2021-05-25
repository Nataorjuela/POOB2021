

package Aplicacion;

import java.awt.Color;


public class Dulce extends Alimento {
   
    Color colorDulce=new Color( 26, 35, 126);

    public Dulce(){
       this.colorComida=colorDulce;
        cambiarPos(-1,-1);
        }
    
     public void cambiarPos(int a, int b){
         comida[0]=a; 
         comida[1]=b;
    }
     
}