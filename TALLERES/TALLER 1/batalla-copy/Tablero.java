import java.util.ArrayList;
public class Tablero {
  private int puntaje;
  private int longitud;
  private int latitud;
  private boolean mundo;
  private ArrayList<Flota>flotas;
  /**
    * Constructo de la clase Tablero
    */
  public Tablero(){
       if ((longitud>-101 && longitud<101)&&(latitud>-101 && latitud<101)){ 
           mundo=true;
        }
    } 
  /**
   * este metodo devuelve el puntaje de la flota.
   * @param int posicion es la flota de la cual se quiere obtener el puntaje 
   * @return int puntaje obtenido
   */  
  public int getPuntaje(int posicion){
       return flotas.get(posicion).getPuntaje();
    }
  /**alias(**)
  * public int alias(**)
  * Consulta el número de flotas que tienen su mismo nombre
  * Returns:
  * numero de flotas con el mismo nombre

  * CLASE: TABLERO
  * metodo que retorna el numero de flotas que obtuvieron un mismo nombre
   @return conta int variable que contiene la cantidad flotas que obtuvieron un mismo nombre
   */
  public int alias()
  {
      int conta=0;
      for (int i=0;i<flotas.size();i++)
	{
	 for(int j=i+1;j<flotas.size();j++)
	 {
	    if (flotas.get(i).getName()==flotas.get(j).getName())
		{
		conta+=1;
		}
	 }
        }
      return conta;
  }  
}
