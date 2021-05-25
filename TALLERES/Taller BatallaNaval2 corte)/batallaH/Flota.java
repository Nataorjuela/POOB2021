 

import java.util.ArrayList;

public class Flota {
        private Tablero tablero;
	private String nombre;
	private ArrayList<Marino> marinos;
	private ArrayList<Maquina>maquinas;
	/**
	 * Este método mueve todas las máquinas la distancia definida
	 * El mundo tablero es circular. Longitud [0,180] Latitud [-90,90]. Coordenadas.
	 * @param dLon - avance en longitud
	 * @param dLat - avance en latitud
	 */
	public void avance(int dLon, int dLat){
	   for(int i=0;i<maquinas.size();i++){
	       maquinas.get(i).avance(dLon,dLat);
	   }
	}
	/**
	 * Consulta las máquinas débiles de una flota 
	 * Un barco es débil si tienen menos de cinco marinos; un avión, si no tiene piloto principal; 
	 * y un portaaviones si es un barco débil o alguno de sus aviones en aire es débil.
	 * @return 
	 */
	public ArrayList<Maquina> maquinasDebiles(){ 
	   ArrayList<Maquina> debiles=new ArrayList<Maquina>();
	   for(int i=0;i<maquinas.size();i++){
	       if(maquinas.get(i).esDebil()){
	          debiles.add(maquinas.get(i));
	       }
	   }
	   return debiles;
	}
}
