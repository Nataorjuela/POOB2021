 import java.util.ArrayList;

public class Maquina {
	private Ubicacion ubicacion;
	private ArrayList<Maquina>maquinas;
	public void avance(int dlong,int dlat){
	   ubicacion.avance(dlong,dlat);
	 }
	public boolean esDebil(){
	    return false;
	 }
}
