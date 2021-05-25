
package Aplicacion;

import java.awt.Color;

public class poder extends Alimento {
    
    
    
    Color colorPoder=new Color(153, 255, 0 );
   

    public poder(){
        this.colorComida=colorPoder;
       cambiarPos(-1,-1);
      
    }
    
    public void cambiarPos(int a, int b){
         comida[0]=a; 
        comida[1]=b;
    }
    
    
}