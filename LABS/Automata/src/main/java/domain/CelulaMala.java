package domain;
import java.io.Serializable;
import java.awt.Color;

/**Informacion sobre una célula<br>
<b>(automata,fila,columna,edad, estado, estadoSigiente, color)</b><br>
Las celulas conocenel automata en la que viven, la posición en la que están en ese autómata,su edad, su estado actual y el estado que van a tomar en el siguiente instante.<br>
Todas las células son de color azul<br>
 */
public class CelulaMala extends Ser implements Elemento,Serializable{
    protected char estadoSiguiente;
   
    protected Color color;
    private AutomataCelular automata;
    private int fila,columna;
        /**Crea una célula en la posición (<b>fila,columna</b>) del autómta <b>ac</b>.Toda nueva célula va a estar viva en el estado siguiente.
    @param ac automata celular en el que se va a ubicar la nueva célula
    @param fila fila en el automata celular
    @param columna columna en el automata celula
     */
    public CelulaMala(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        
        estadoSiguiente=Ser.VIVO;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.magenta;
    }
    @Override
    public int forma(){
      return CUADRADA;
      }
    /**Retorna la fila del automata en que se encuentra 
    @return 
     */
    public final int getFila(){
        return fila;
    }

    /**Retorna la columna del automata en que se encuentra
    @return 
     */
    public final int getColumma(){
        return columna;
    }

    /**Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
    public void decida(){
        if (getEdad()>=10){
            estadoSiguiente=Ser.MUERTO;
        }  
        else if (getEdad()>=5){
            color=Color.black;
        } 
    }
    /**Actualiza su estado actual considerando lo definido como siguiente estado
     */
    public final void cambie(){
        cumple();
        estado=estadoSiguiente;
        decida();
    }
    
    public char getEstado(){
        return estado;
    
    }
}