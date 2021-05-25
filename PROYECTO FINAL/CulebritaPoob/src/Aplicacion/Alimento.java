
package Aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


public class Alimento extends JPanel {
    
    //Atributos de clase
    public int puntaje;
    public Color colorComida=Color.WHITE;
    public int [] comida= new int[2];
    public List<int[] > snake= new ArrayList<>(); 
    public int tamp,tamc,cantidad;
    public int residuo;


    public Alimento(){
        this.tamp=800;
        this.cantidad=30;
        this.tamc=tamp/cantidad;
        this.residuo=tamp%cantidad;    
    }
    
    public void generarComida(){
         int a=(int) (Math.random()*cantidad);
         int b=(int) (Math.random()*cantidad);
         this.comida[0]=a;
         this.comida[1]=b;            
    }
    /**/
    public  int [] getComida(){
        return comida;
    }
    public Color getColor(){
        return colorComida;
    }
}