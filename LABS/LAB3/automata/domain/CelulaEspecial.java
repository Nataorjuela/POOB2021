package domain;

import java.awt.Color;
import java.util.*;
/**Informacion sobre una célula<br>
<b>(automata,fila,columna,edad, estado, estadoSigiente, color)</b><br>
Las celulas conocenel automata en la que viven, la posición en la que están en ese autómata,su edad, su estado actual y el estado que van a tomar en el siguiente instante.<br>
Todas las células son de color azul<br>
 */
public class CelulaEspecial extends Celula{
    private AutomataCelular automata;
    private int fil,col;
    
    public CelulaEspecial(AutomataCelular automata, int fil, int col){
         super(automata,fil,col);
         color=color.green;
         this.automata=automata;
         this.fil=fil;
         this.col=col;
    }
    public void isSola(){
        Elemento[][]matriz=automata.getAutomata();
        ArrayList<Elemento> vecinas=new  ArrayList<Elemento>();
        for(int i=0;i<fil;i++){
           for(int j=0;j<col;j++){
               if(matriz[i][j]!=null){
                   if(i==0){
                       if(j==0){
                           vecinas.add(matriz[0][1]);
                           vecinas.add(matriz[1][0]);
                           vecinas.add(matriz[1][1]);
                         }
                       else if(j==fil){
                           vecinas.add(matriz[0][j-1]);
                           vecinas.add(matriz[1][j]);
                           vecinas.add(matriz[1][j-1]);
                         }   
                         
                         
                         
                        else{
                            vecinas.add(matriz[0][j-1]);
                            vecinas.add(matriz[0][j+1]);
                            vecinas.add(matriz[1][j-1]);
                            vecinas.add(matriz[1][j]);
                            vecinas.add(matriz[1][j+1]);
                        }
                   }
                   else if(i==fil){
                       if(j==0){
                           vecinas.add(matriz[fil][1]);
                           vecinas.add(matriz[fil-1][0]);
                           vecinas.add(matriz[fil-1][1]);
                         }
                       else if(j==fil){
                           vecinas.add(matriz[fil][j-1]);
                           vecinas.add(matriz[fil-1][j-1]);
                           vecinas.add(matriz[fil-1][j]);
                         }   
                        else{
                            vecinas.add(matriz[fil][j-1]);
                            vecinas.add(matriz[fil][j+1]);
                            vecinas.add(matriz[fil-1][j-1]);
                            vecinas.add(matriz[fil-1][j]);
                            vecinas.add(matriz[fil-1][j+1]);
                        }
                   }
                   else{
                            vecinas.add(matriz[i-1][j-1]);
                            vecinas.add(matriz[i-1][j+1]);
                            vecinas.add(matriz[i-1][j]);
                            vecinas.add(matriz[i][j-1]);
                            vecinas.add(matriz[i][j+1]);
                            vecinas.add(matriz[i+1][j+1]);
                            vecinas.add(matriz[i+1][j-1]);
                            vecinas.add(matriz[i+1][j]);
                    }
               }
            }
        }

  }
   public int solos(ArrayList<Elemento> vecinas){
     boolean x=true;
     int pos=vecinas.size()+1;
     for (int i=0;i<vecinas.size();i++){
         if (vecinas.get(i)!=null){
             if (vecinas.get(i).isVivo()){
                x=false;
                }
            }
        }
     boolean primera=true;
     if (x==false){
        for (int i=0;i<vecinas.size();i++){
         if (vecinas.get(i)==null && primera){
             pos=i;
             primera=false;
            }
        }
        
     }
        
     return pos;
  }
  
  @Override
  public void decida(){
      super.cambie();
      
      
    }
}
