 

import java.util.ArrayList;

public class Barco extends Maquina{
    private int numero;
    private ArrayList<Marino> marinos;
    public boolean esDebil(){
        boolean result=false;
        if (marinos.size()<5){
            result=true;
        }
        return result;
    }
}
