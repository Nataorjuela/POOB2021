

package Aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Dulce extends JPanel {
   
    Color colorComida=new Color( 26, 35, 126);
    int [] comida= new int[2];
    
    List<int[] > snake= new ArrayList<>();
    
    int tamp,tamc,cantidad;
    int residuo;


    public Dulce(int tamp,int cantidad){
       
        this.tamp=tamp;
        this.cantidad=cantidad;
        this.tamc=tamp/cantidad;
        this.residuo=tamp%cantidad;
        generarComida();
    }
    
    public  int [] getComida(){
        return comida;
    }
    public Color getColor(){
        return colorComida;
    }

    public void generarComida(){
        boolean existe=false;
            int a=(int) (Math.random()*cantidad);
            int b=(int) (Math.random()*cantidad);
            
            for (int[] sn:snake){
                if (sn[0]==a && sn[1]==b){
                    existe=true;
                    generarComida();
                    break;
                }
            }
            if (!existe){
                this.comida[0]=a;
                this.comida[1]=b;
            }   
    }
}