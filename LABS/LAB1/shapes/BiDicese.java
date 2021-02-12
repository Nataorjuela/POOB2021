import javax.swing.JOptionPane;
import java.lang.*;
/**
 * Write a description of class BiDicese here.
 * 
 * @author (Natalia Orjuela y Diego Macana ) 
 * @version (4/02/2021)
 */
public class BiDicese
{
    // instance variables - replace the example below with your own
    private Dicese[] juegos;
    private int n;
    private boolean win;
    private int juegosJugados;
    private int ganados;
    private float porcenSave;
    
    /**
     * Constructor for objects of class BiDicese
     * @param int n cantidad de dados
     */
    public BiDicese(int n)
    {
        // initialise instance variables
       if (n<2 || n>6){
        JOptionPane.showMessageDialog(null, "Por favor ingresar un valor entre 2 y 6.");
        System.exit(0);
        }
       this.n=n; 
       juegos=new Dicese[n];
       juegosJugados=0;
       porcenSave=0;
       for (int i=0;i<n;i++)
       {
           juegos[i]=new Dicese(n); 
           for (int j=0;j<i;j++)
           {
               juegos[i].moveVertical();
           }
           juegos[i].makeVisible();
       }
       
    }
    /**
     * metodo para jugar con todas las filas de dados
     * juegos[] es un array de filas de dados
     */
    public void playTodos(){
        for (int i=0;i<n;i++)
        { 
            juegos[i].play();
            
        }
        juegosJugados+=1; 
        
    }
    /**
     * metodo para jugar con una fila de dados
     * @param int fila parametro para indicar el numero de fila 
     */
    public void playUnaFila(int fila){
        juegos[fila-1].play();
        juegosJugados+=1;
        
    }
    /**
     * metodo para jugar con un dado
     * @param int fila , int columna parametro para indicar el numero de fila y columna del dado
     */
    public void playUnDado(int fila, int columna){
        juegos[fila-1].playUnDado(columna);
        juegosJugados+=1;
        
    } 
    /**
     * metodo para saber si se gano o no.
     * 
     */
    public void resultado(){
        
        int conta=juegos[0].getDado(0);
        int ganoAD=1,ganoDD=1,ganoAC=1,ganoDC=1,ganoFIL=0,ganoCOL=0;
        for (int i=1;i<n;i++) //filas
        {
            for (int j=1;j<n;j++)  //columnas
            {
              if (i==j)
              {
                 // System.out.println("i"+i+"j"+j);
                  //System.out.println("dado a comparar :"+conta+"contra: "+juegos[i].getDado(j));
                 if (conta+1==juegos[i].getDado(j))
                 {
                     ganoAD+=1;
                     //System.out.println("+");
                     conta=juegos[i].getDado(j);
                 }
                 else if (conta-1==juegos[i].getDado(j))
                 {
                     ganoDD+=1;
                     //System.out.println("-");
                     conta=juegos[i].getDado(j);
                 }
                 else{ j=n;}
              }
              
            }
        }
        int j=0;
        for (int i=0;i<n;i++) //filas  
        {
            conta=juegos[0].getDado(i);
            //System.out.println("pivote nuevo: "+conta);
            //System.out.println("AC"+ganoAC);
            //System.out.println("DC"+ganoDC);
            if (juegos[i].resultadoFIl()){
                ganoFIL=n;
            }
            for (int k=1;k<n;k++)  //columnas
            {    
                //System.out.println("comparamos "+conta+"contra"+juegos[k].getDado(i));
                if (conta+1==juegos[k].getDado(i)) 
                {
                    ganoAC+=1;
                    //System.out.println("+");
                    conta=juegos[k].getDado(i);
                }
                else if (conta-1==juegos[k].getDado(i))
                {
                    ganoDC+=1;
                    //System.out.println("-");
                    conta=juegos[k].getDado(i);
                }
                
            }
            if (ganoAC==n || ganoDC==n){
                    ganoCOL=n;
                }
            //System.out.println("AC antes"+ganoAC);
            //System.out.println("DC antes"+ganoDC);    
              
            ganoAC=1;
            ganoDC=1;
            j+=1;
        }
        if (ganoAD==n || ganoDD==n || ganoCOL==n || ganoFIL==n )
        {
            //System.out.println("Ganaste!!!!(♥-♥)");
            JOptionPane.showMessageDialog(null, "Ganaste!!!!(♥-♥)");
            win=true; 
            ganados+=1;
        }
        else 
        {    
            JOptionPane.showMessageDialog(null, "Perdiste (L-L)");
            //System.out.println("Perdiste (L-L)");
            win=false;
        }
       
    }
    /**
     * metodo para reiniciar un juego
     * 
     */
    public void reset()
    {
        juegosJugados=0;
        ganados=0;
        for (int i=0;i<n;i++)
        {
            juegos[i].reset();
        }
    }
    /**
     * metodo para cambiar los colores de los dados cuando se consigue ganar el juego
     * 
     */
    public void superwin(){
        if (win){
            for (int i=0;i<n;i++){
                juegos[i].superWin();
            }
        }
    }
    /**
     * metodo para saber el porcentaje de victoria.
     * 
     * @return porwin retorna el porcentaje de victoria del total de juegos.
     */
    public float percentageOfWinningStates(){
        float porwin=ganados*100/juegosJugados;
        porcenSave=porwin;
        return porwin;
        
    }
}
