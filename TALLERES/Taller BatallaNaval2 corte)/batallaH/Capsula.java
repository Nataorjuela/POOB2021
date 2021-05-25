
/**
 * Write a description of class Capsula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capsula extends Nodriza
{
    // instance variables - replace the example below with your own
    private Maquina nave;
    private int profundidad; 
    /**
     * Constructor for objects of class Capsula
     */
    public Capsula(Maquina maquinaN)
    {
        nave=maquinaN;
        if (nave instanceof Barco || nave instanceof Capsula){ 
            
        }
    }
    public boolean esDebil(){
        return false;
    }
    public boolean nodrizaDestruida(){
        return nave.getDestruida();
    }
     public void autoDestruir(){
        if(nodrizaDestruida()){
            destruir();
            System.out.println("Causa:Nodriza destruida");
        }
    }
     public void direccion(){
        avance(x,y);
    }
}
