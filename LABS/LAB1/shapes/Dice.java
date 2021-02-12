import java.util.*;

/**
* DICE es una clase que simula el uso de un dado.
* 
* @author (Diego Macana-Natalia Orjuela) 
* 
*/
public class Dice
{
   private  int valor;
   private Rectangle forma;
   private Circle[] puntos;
   private boolean isVisible;
   /**
   * Constructor of dice to play
   */
    public Dice()
    { 
     forma=new Rectangle();
     forma.changeSize(100,100);
     puntos=new Circle[6];
     isVisible=false;
     for(int i=0;i<puntos.length;i++){
           puntos[i]=new Circle();
    }
    }
   /**
     * Este método muestra el dado
     */
    public void makeVisible()
    {
       isVisible=true;
       forma.makeVisible();
       for(int i=0;i<valor;i++){
           puntos[i].makeVisible();
        }
    }
   /**
   * Este método oculta el dado
   */
    public void makeInvisible()
    {
        isVisible=false;
        forma.makeInvisible();
        for(int i=0;i<puntos.length;i++){
           puntos[i].makeInvisible();
         }
    }
    /**
     * metodo para jugar cambiar el color de un dado
     * 
     */
    public void superWin()
    {
        String[] colores= {"orange","yellow","red","blue","especial_diego"};
        forma.rainbow(colores);
    }
   /**
     * Metodo que permite trasladar el dado horizontalmente
     * @parameter distance int
     */
     public void moveHorizontal(int distance){
        forma.moveHorizontal(distance);
        for(int i=0;i<puntos.length;i++){
           puntos[i].moveHorizontal(distance);
         }
    }
    /**
     * Metodo que permite trasladar el dado horizontalmente
     * @parameter distance int
     */
     public void moveVertical(int distance){
        forma.moveVertical(distance);
        for(int i=0;i<puntos.length;i++){
           puntos[i].moveVertical(distance);
         }
    }
    
    /**
     * Este método lanza aleatoriamente el dado
     */
   public void roll()
     {
       for(int i=0;i<puntos.length;i++){
           puntos[i].makeInvisible();
        }
        int num=(int)(Math.random()*6+1);
        valor=num;
        int x=forma.getX();
        int y=forma.getY();
      
        if(valor==1){
           puntos[0].setX(x+40); //punto mitad
           puntos[0].setY(y+45); 
        }
       else if(valor==2){
           puntos[0].setX(x+20); //punto esquina superior izq
           puntos[0].setY(y+10); 
           puntos[1].setX(x+60); //punto esquina inf der
           puntos[1].setY(y+70); 
        }
       else if(valor==3){
           puntos[0].setX(x+20); 
           puntos[0].setY(y+10); 
           puntos[1].setX(x+40); 
           puntos[1].setY(y+40); 
           puntos[2].setX(x+60); 
           puntos[2].setY(y+70);
       }
       else if(valor==4){
           puntos[0].setX(x+20); 
           puntos[0].setY(y+10); 
           puntos[1].setX(x+60); //esquina sup der
           puntos[1].setY(y+10); 
           puntos[2].setX(x+20); //esq inf iz
           puntos[2].setY(y+70);
           puntos[3].setX(x+60);//esq inf der
           puntos[3].setY(y+70);
        }
        else if(valor==5){
           puntos[0].setX(x+20); 
           puntos[0].setY(y+10); 
           puntos[1].setX(x+60); //esquina sup der
           puntos[1].setY(y+10); 
           puntos[2].setX(x+20); //esq inf iz
           puntos[2].setY(y+70);
           puntos[3].setX(x+60);//esq inf der
           puntos[3].setY(y+70);
           puntos[4].setX(x+40); //punto mitad
           puntos[4].setY(y+40);           
        }
        else if(valor==6){
           puntos[0].setX(x+20); 
           puntos[0].setY(y+10);
           puntos[1].setX(x+60); //esquina sup der
           puntos[1].setY(y+10);
           puntos[2].setX(x+20); //mitad iz
           puntos[2].setY(y+40);
           puntos[3].setX(x+60); //mitad der
           puntos[3].setY(y+40);           
           puntos[4].setX(x+60); //esq inf der
           puntos[4].setY(y+70);
           puntos[5].setX(x+20);//esq inf izq
           puntos[5].setY(y+70);
           
        }
        if(isVisible){
            makeVisible();
        }
    }
    /**
     * Método que permite cambiar el color del dado 
     * @parameter color String ejemplo:"red"
     */
     public void changeColor(String color)
     {
        forma.changeColor(color);
     }
    /**
     * Este método devuelve el valor del dado
     * @return int 
     */
    public int getValue(){
        return valor;
    }
    
    public void setValue(int num ){
        valor=num;
    }
    
    public int getX(){
        return forma.getX();
    }
    public int getY(){
        return forma.getY();
    }
}
