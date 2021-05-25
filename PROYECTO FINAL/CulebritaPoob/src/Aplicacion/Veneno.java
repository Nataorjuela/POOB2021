
package Aplicacion;

import java.awt.Color;



public class Veneno extends Alimento{
   
    Color colorVeneno=new Color( 33, 33, 33);
   


    public Veneno(){
       this.colorComida=colorVeneno;
       cambiarPos(-1,-1);
    }
    
    public void cambiarPos(int a, int b){
         comida[0]=a; 
        comida[1]=b;
    }
    
   
}
