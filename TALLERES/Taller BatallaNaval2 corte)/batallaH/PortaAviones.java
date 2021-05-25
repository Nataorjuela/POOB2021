import java.util.ArrayList;
public class PortaAviones extends Barco{
    private int capacidad;
    private ArrayList<Avion> aviones;
    public boolean esDebil(){
       for(int i=0;i<aviones.size();i++){
        if(esDebil()||(aviones.get(i).getEnAire()&&aviones.get(i).esDebil())){
         return true;
        }
       }
       return false;
      }
}
