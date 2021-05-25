
package Aplicacion;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Snake  extends JPanel {
    Color colorSnake =new Color (34, 153, 84); 
    List<int[] > snake= new ArrayList<>();
    
    int tamp,tamc,cantidad;
    int residuo;
   
    String direccion="de";
   
    String direccionProxima="de";


    public Snake(int tamp,int cantidad){

        this.tamp=tamp;
        this.cantidad=cantidad;
        this.tamc=tamp/cantidad;
        this.residuo=tamp%cantidad;
    }
   
    public void empezarEn(int aa, int bb){
         int [] a={bb,bb};
        int [] b={aa,aa};
        snake.add(a);
        snake.add(b);
       
    }
    public int[] avanzar (){
    igualarDir();   
    int[] ultimo =snake.get(snake.size()-1);
    int agregarx=0;
    int agregary=0;
    
    switch (direccion){
            case "de":agregarx=1;break;
            case "iz":agregarx=-1;break;
            case "ar":agregary=-1;break;
            case "ab":agregary=1;break;
        }
      int [] nuevo ={ ultimo[0]+agregarx ,ultimo[1]+agregary};
      
      if (nuevo[0]>cantidad-1 ||  nuevo[1]>cantidad-1 || nuevo[0]==-1 || nuevo[1]==-1){
         JOptionPane.showMessageDialog(null, "Has perdido, chocaste :( ");
        System.exit(0); 
      }
        for (int i = 0; i < snake.size(); i++) {
            if (nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
                JOptionPane.showMessageDialog(null, "Has perdido");
                System.exit(0); 
                 }
            }
          return nuevo;
    }
    
    

    public void setSnake(int[] nuevo){
            snake.add(nuevo);
    }
    
     public void setSnake2(int n){
            snake.remove(n);
    }

    public void cambiarDireccion (String dir){
        if ( (this.direccion.equals("de") || this.direccion.equals("iz")) && (dir.equals("ar") || dir.equals("ab")) ){
             this.direccionProxima=dir; }
        if ( (this.direccion.equals("ar") || this.direccion.equals("ab")) && (dir.equals("iz") || dir.equals("de")) ){
             this.direccionProxima=dir; }
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
    public Color getColor(){
        return colorSnake;
        }
    public void setColor(Color color){
    colorSnake=color;
        }

    public int getResiduo(){return residuo;}
    public int getCantidad(){return cantidad;}
    public int getTamC(){return tamc;}
   
}