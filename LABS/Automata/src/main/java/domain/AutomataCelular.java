package domain;
import java.io.Serializable;
import java.util.*;

/*No olviden adicionar la documentacion*/

public class AutomataCelular implements Serializable{
    static private int LONGITUD=30;
    private Elemento[][] automata;
    
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        Elemento clase;
        int posicion;
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
        
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        Celula indiana=new Celula(this,1,1);
        Celula oo7=new Celula(this,2,2);
        automata[1][1]=indiana;
        automata[2][2]=oo7;
        CelulaEspecial agamenon=new CelulaEspecial(this,3,3);
        CelulaEspecial venus=new CelulaEspecial(this,4,4);
        automata[3][3]=agamenon;
        automata[4][4]=venus;
        Calefactores surOeste=new Calefactores(this,0,0);
        Calefactores NorOeste=new Calefactores(this,0,LONGITUD-1);
        automata[0][0]=surOeste;
        automata[0][LONGITUD-1]=NorOeste;
        
        CelulaMala natalia=new CelulaMala(this,5,5);
        automata[5][5]=natalia;
        
        CelulaMala diego=new CelulaMala(this,5,6);
        automata[5][6]=diego;
    }
    
    public void ticTac(){
        for(int i=0;i<automata.length;i++){
            for(int j=0;j<automata.length;j++){
                if (automata[i][j]!=null){
                   automata[i][j].cambie();
                }
            }
        }
    }
    
    public Elemento[][] getAutomata(){
       return automata;
    }
    
    
    
}

