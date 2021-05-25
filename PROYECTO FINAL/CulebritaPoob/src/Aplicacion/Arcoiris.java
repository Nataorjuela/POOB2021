
package Aplicacion;


import java.awt.Color;



public class Arcoiris extends Alimento {
    Color arcoi =new Color(123, 31, 162);

    public Arcoiris(){
        this.colorComida=arcoi;
        cambiarPos(-1,-1);
    }
    
    public void cambiarPos(int a, int b){
         comida[0]=a; 
         comida[1]=b;
    }

}