import java.util.ArrayList;
public class Flota 
{
   private String nombre;
   private final int tripulantes=15;
   private String placa;
   private final String codigo=placa;//constante,cada flota debe tener un codigo como la placa
   private ArrayList <PortaAviones> portaAviones;
   private ArrayList <Avion> aviones;
   private ArrayList <Barco> barcos;
   private ArrayList <Marino> marinos;
   
   public Flota()
    {
        portaAviones=new ArrayList<PortaAviones>();
        aviones=new ArrayList<Avion>();
        barcos=new ArrayList<Barco>();
    }
    /**
     * Este método devuelve el valor verdadero o falso para identificar si una flota se puede modificar.
     * @return boolean el cual es el identificador para saber si se puede  modificar la flota.
     */
    public String getCodigo()
    {
          return codigo;
    }
      /**
    *Este método modifica el valor del puntaje el cual se obtiene con cada elemento de guerra(potaavioneson,barcoso y avioneson)
    *@return int x el cual es la suma total de los puntajes de cada elemento.
    *
    */
    public int getPuntaje()
    {
        int x=0;
            for(int i=0;i<portaAviones.size();i++){
            x+=portaAviones.get(i).getPuntaje();
        }
            for(int i=0;i<aviones.size();i++){
            x+=aviones.get(i).getPuntaje();
        }
            for(int i=0;i<barcos.size();i++){
            x+=barcos.get(i).getPuntaje();
        } 
        return x;
    }
    /**
     * numeroMaquinas (*)
     * /**Consulta el numero de maquinas que tiene la flota
     * Returns:
     numero de maquinas de la flota 
     public int numeroMaquinas()
     CLASE: FLOTA
      /*
      *metodo que retorna el numero de maquinas que tiene una flota.
      *@return num int retorna cantidad de maquinas que tiene una flota.
      */

     public int numeroMaquinas()
        {
	int num=0;
	int cantPortaavioneson=portaAviones.size();
	int cantavioneson=aviones.size();
	int cantbarcoso=barcos.size();
	num=cantPortaavioneson+cantavioneson+cantbarcoso;
	
	return num;
      }
    /**suficientesMarinos(*)
       * public boolean suficientesMarinos()
       * Consulta si cuenta con suficientes marinos para conducir sus máquinas.
       * Un portaavionesones requiere cinco marinos; un barcoso, 4; y un avionesón 2.
       * Returns:
       * si hay problema en aire

       * CLASE: FLOTA
       * /**
       *metodo que retorna si los marinos pueden ocupar todas las maquinas de una flota
       *@return  false cuando los marinos no son suficientes
        *@return true cuando los marinos cumplen con la capacidad de la flota y sus maquinas
        */
       public boolean suficientesMarinos()
       {
	int cantMarinos=marinos.size();
	int cantPortaavioneson=portaAviones.size();
	int cantavioneson=aviones.size();
	int cantbarcoso=barcos.size();
	int num=0;
	boolean respuesta;
	num=(cantPortaavioneson*5)+(cantbarcoso*4)+(cantavioneson*2);
	if (num>=cantMarinos){
	       respuesta=true;
	
	}
	else{
	    respuesta=false;
		
	}
	return respuesta;
       }

     /**
         *esBuenAtaque (1***)
         
        public boolean esBuenAtaque(int longitud, int latitud)
        Verifica si una ubicación de ataque en agua es adecuado
        (destruye elementos enemigos sin ocasionar bajas propias)
        Parameters:
        longitud - longitud de la explosion
        latitud - latitud de la explosion 
        
        CLASE:FLOTA
    /*
     * metodo que Verifica si una ubicación de ataque en agua es adecuado
     * @param longitud - longitud de la explosion
     * @param latitud - latitud de la explosion 
     * @return true si es un buen ataque 
     * @return false no es un buen ataque
     */
    public boolean esBuenAtaque(int longitud, int latitud)
    {
	boolean boolean1=mePegue( aviones,longitud,latitud);
	boolean boolean2=mePegue( portaAviones,longitud,latitud);
	boolean boolean3=mePegue( barcos,longitud,latitud);
	if (boolean1 && boolean2 && boolean3)	
	{
		return true;
	}
	else
	{
		return false;
	}
     }
    /**
     * Este metodo revisa la posicion de una flota 
     * 
     */
    private boolean mePegue( ArrayList<Object> maquina,int longitud,int latitud)
    {
    	for (int i=0;maquina.size();i++)
    	{
    		if (maquina.getPosicion().getLongitud()==longitud && maquina.getPosicion().getLatitud()==latitud)
    		{
    			 return false;
    		}
    	}
       return true;
    }
}