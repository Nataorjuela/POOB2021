import java.util.*;
import javax.swing.JOptionPane;
    /**
     * Esta clase simula dos zonas la zona de la bodega y la zona de plan de robo
     * 
     * @author (Macana-Orjuela) 
     * @version (2021)
     */
public class Mission
    {
    // instance variables - replace the example below with your own
    private int width;
    private int length;
    private int[][]matriz;
    private int[][]matrizLadron;
    private int rowRobo;
    private int columnRobo;
    private int valorRobado;
    private boolean isVisible;
    private int distanceX;
    private Rectangle [][]cajasSide;
    private Rectangle [][]cajasSideLadron;
    private Rectangle [][]cajasTop;
    private Rectangle [][]cajasTopLadron;
    private Rectangle [][]cajasFront;
    private Rectangle [][]cajasFrontLadron;
    private boolean ok;
    /**
     * Constructor for objects of class Mission
     * @param int width ingresar un valor entero para el ancho de la matriz.
     * @param int length ingresar un valor entero para el largo de la matriz.
     */
    public Mission(int width,int length)
    {
      this.width=width;
      this.length=length;
      int [][] matriz=new int[width][length];
      int [][] matrizLadron=new int[width][length];
      isVisible=false;
      Rectangle[][] cajasFrontLadron=new Rectangle[width][100];
      Rectangle[][] cajasSideLadron=new Rectangle[width][100];
      Rectangle[][] cajasTopLadron=new Rectangle[width][length];
      Rectangle[][] cajasTop=new Rectangle[width][length];
      Rectangle[][] cajasSide=new Rectangle[width][100];
      Rectangle[][] cajasFront=new Rectangle[width][100];
      this.cajasFrontLadron=cajasFrontLadron;
      this.cajasSideLadron=cajasSideLadron;
      this.cajasTopLadron=cajasTopLadron;
      this.cajasTop=cajasTop;
      this.cajasSide=cajasSide;
      this.cajasFront=cajasFront;
      if (width<101 && width>0 && length<101 && length>0){ 
      for(int i=0;i<width;i++){
        for(int j=0;j<length;j++){
            Random numero=new Random();
            matriz[i][j]=numero.nextInt(30);
            matrizLadron[i][j]=0;
        }
      }
      this.matriz=matriz;
      this.matrizLadron=matrizLadron;
      }
     else {
        JOptionPane.showMessageDialog(null, "Por favor ingresar un valor entre 1 y 100 para width y length");
        System.exit(0); 
    
     }
   }
   /**
      * Este método simula el almacenamiento de una caja en la bodega. 
     * 
     * @param  row   valor entero que representa la fila de la caja que quiere almacenar.
     * @param  column   valor entero que representa la column de la caja que quiere almacenar.
     * 
     */
    public void store(int row,int column){
       ok=true;
       if (row<101 && row>0 && column<101 && column>0){ 
        matriz[row-1][column-1]+=1;
        this.matriz=matriz;
         }
       else {
        ok=false;
        JOptionPane.showMessageDialog(null, "ingresa nuevamente los valores en un rango de 1 a 100");
       }
   }
   /**
    * Este método copia el estado actual de la matriz de la bodega en la zona de plan de robo.
    */
   public void copy(){
        int [][] matrizLadron=new int[width][length];
       for(int i=0;i<width;i++){
           for(int j=0;j<length;j++){
               matrizLadron[i][j]=matriz[i][j];
        }
       }
       this.matrizLadron=matrizLadron;
       ok=true;
    }
    /**
     * Este método roba una caja de la bodega en la posicion indicada.
     * @param  row   valor entero que representa la fila de la caja que quiere robar.
     * @param  column   valor entero que representa la column de la caja que quiere robar.
     */
   public void steal(int row,int column){
       this.valorRobado=matriz[row-1][column-1]-1;
       this.rowRobo=row;
       this.columnRobo=column;
       matriz[row-1][column-1]=1;
       matrizLadron[row-1][column-1]=valorRobado;
       ok=true;
     }
     /**
      * Este método devuelve la caja robada a la bodega.
      */
   public void returnn(){
       matrizLadron[rowRobo-1][columnRobo-1]-=valorRobado;
       matriz[rowRobo-1][columnRobo-1]+=valorRobado;
       ok=true;
    }
    /**
     * Este método Reorganiza las filas de la matriz de manera ascendente.
     *@param from es la fila desde la cual se quiere iniciar a organizar la matriz ejemplo:{5,8,3}
     *@param to es la fila hasta la cual se quiere finalizar de ordenar la matriz ejemplo:{3,9,10}}
     */
   public void arrange(int[] from, int[] to){
       int cont=0;
       for(int i=0;i<from.length;i++){
           cont=0;
           for(int j=0;j<from.length;j++){
           if (matriz[i][j]==from[j]){
               cont+=1;
               
            }
          }
          if (cont==from.length){
            Arrays.sort(matriz[i]);
            }
        }
       this.matriz=matriz;
       ok=true;
   }
   /**
    * Consultar las piezas robadas en el último plan
    * @return valor de la caja robada.
    */
   public int stolen(){
     return valorRobado;
   }
   /**
    * Este método Consulta las cajas que hay en bodega , mostrando su  matriz y vistas de las camaras.
    * 
    * @return  la matriz de la zona de bodega.
    */
   public int[][]warehouse(){
       for (int x=0; x < matriz.length; x++) {
         System.out.print("|");
         for (int y=0; y < matriz[x].length; y++) {
             System.out.print (matriz[x][y]);
             if (y!=matriz[x].length-1) System.out.print("\t");
            }
         System.out.println("|");
        }
       this.cajasFront=front(matriz,cajasFront);
       this.cajasSide=side(matriz,cajasSide);  
       this.cajasTop=top(matriz,cajasTop);
       ok=true;
       return matriz;    
    }
    /**
    * Este método Consulta las cajas que hay en el plan de robo, mostrando su  matriz y vistas de las camaras.
    * 
    * @return  la matriz de la zona de robo.
    */
   public int[][]layout(){
    for (int x=0; x < matrizLadron.length; x++) {
         System.out.print("|");
         for (int y=0; y < matrizLadron[x].length; y++) {
             System.out.print (matrizLadron[x][y]);
             if (y!=matrizLadron[x].length-1) System.out.print("\t");
            }
         System.out.println("|");
        }
    this.cajasFrontLadron=front(matrizLadron,cajasFrontLadron);
    this.cajasSideLadron=side(matrizLadron,cajasSideLadron);
    this.cajasTopLadron=top(matrizLadron,cajasTopLadron);
    ok=true;
    return matrizLadron;
    }
   private Rectangle[][] top(int[][]m,Rectangle[][]cajas){
       distanceX+=(25*length)+10;
       int aux=distanceX;
       int distanceY=0;
       for(int i=0;i<length;i++){
        for(int j=0;j<width;j++){
            cajas[i][j]=new Rectangle();
            if(m[i][j]==0){
                cajas[i][j].makeInvisible();
            }
            else{
            cajas[i][j].makeVisible();
            }
            cajas[i][j].moveVertical(distanceY);
            cajas[i][j].moveHorizontal(distanceX);
            distanceX+=25;
          }
        distanceY+=25;
        distanceX=aux;       
       }
       ok=true;
       return cajas;
    }
   private Rectangle[][] side(int[][]m,Rectangle[][]cajas){
    int[] maximos=new int[length];
    int max=0;
    int maxi=0;
    distanceX+=(25*length)+10;
    for(int i=0;i<length;i++){
        for(int j=0;j<width;j++){
            if(max<m[i][j]){
                max=m[i][j];
            }
        }
        maximos[i]=max;
        if(maxi<max){
            maxi=max;
        }
        max=0;
    }
    int distanceY=25*maxi;
    for(int k=0;k<length;k++){
       for(int h=0;h<maximos[k];h++){
           cajas[k][h]=new Rectangle();
           cajas[k][h].makeVisible();
           cajas[k][h].moveVertical(distanceY);
           distanceY=distanceY-25; 
           cajas[k][h].moveHorizontal(distanceX);
           
        }
       distanceX+=25; 
       distanceY=25*maxi;
     }
     return cajas;
    }
   private Rectangle[][] front(int[][]m,Rectangle[][]cajas){
    int[] maximos=new int[length];
    int max=0;
    int maxi=0;
    distanceX=0;
    for(int i=0;i<length;i++){
        for(int j=0;j<width;j++){
            if(max<m[j][i]){
                max=m[j][i];
            }
        }
        maximos[i]=max;
        if(maxi<max){
            maxi=max;
        }
        max=0;
    }
    int distanceY=25*maxi;
    
    for(int k=0;k<length;k++){
       for(int h=0;h<maximos[k];h++){
           cajas[k][h]=new Rectangle();
           cajas[k][h].makeVisible();
           cajas[k][h].moveVertical(distanceY);
           distanceY=distanceY-25; 
           cajas[k][h].moveHorizontal(distanceX);
           
        }
       distanceX+=25; 
       distanceY=25*maxi;
     } 
     ok=true;
    return cajas;
   }
   /**
    * Hace visible el simulador.
    */
   public void makeVisible()
      {
       isVisible=true;
      for(int i=0;i<cajasTop.length;i++){
           for (int j=0;j<cajasTop[i].length;j++){
               if(cajasTop[i][j]!=null)   
                cajasTop[i][j].makeVisible();
           }
       }
      for(int i=0;i<cajasFront.length;i++){
           for (int j=0;j<cajasFront[i].length;j++){
               if(cajasFront[i][j]!=null)   
                cajasFront[i][j].makeVisible();
           }
       }
       for(int i=0;i<cajasSide.length;i++){
           for (int j=0;j<cajasSide[i].length;j++){
               if(cajasSide[i][j]!=null)   
                cajasSide[i][j].makeVisible();
           }
       }
       for(int i=0;i<cajasTopLadron.length;i++){
           for (int j=0;j<cajasTopLadron[i].length;j++){ 
               if(cajasTopLadron[i][j]!=null)   
                cajasTopLadron[i][j].makeVisible();
           }
       }
       for(int i=0;i<cajasSideLadron.length;i++){
           for (int j=0;j<cajasSideLadron[i].length;j++){
               if(cajasSideLadron[i][j]!=null)   
                cajasSideLadron[i][j].makeVisible();
           }
       }
       for(int i=0;i<cajasFrontLadron.length;i++){
           for (int j=0;j<cajasFrontLadron[i].length;j++){
               if(cajasFrontLadron[i][j]!=null)   
                cajasFrontLadron[i][j].makeVisible();
           }
       }
       ok=true;
    }
    /**
    * Hace invisible el simulador.
    */
    public void makeInvisible()
    {
       isVisible=false;
       for(int i=0;i<cajasTop.length;i++){
           for (int j=0;j<cajasTop[i].length;j++){
               if(cajasTop[i][j]!=null)   
                cajasTop[i][j].makeInvisible();
           }
       }
       for(int i=0;i<cajasFront.length;i++){
           for (int j=0;j<cajasFront[i].length;j++){
               if(cajasFront[i][j]!=null)   
                cajasFront[i][j].makeInvisible();
           }
       }
       for(int i=0;i<cajasSide.length;i++){
           for (int j=0;j<cajasSide[i].length;j++){
               if(cajasSide[i][j]!=null)   
                cajasSide[i][j].makeInvisible();
           }
       }
       for(int i=0;i<cajasTopLadron.length;i++){
           for (int j=0;j<cajasTopLadron[i].length;j++){ 
               if(cajasTopLadron[i][j]!=null)   
                cajasTopLadron[i][j].makeInvisible();
           }
       }
       for(int i=0;i<cajasSideLadron.length;i++){
           for (int j=0;j<cajasSideLadron[i].length;j++){
               if(cajasSideLadron[i][j]!=null)   
                cajasSideLadron[i][j].makeInvisible();
           }
       }
       for(int i=0;i<cajasFrontLadron.length;i++){
           for (int j=0;j<cajasFrontLadron[i].length;j++){
               if(cajasFrontLadron[i][j]!=null)   
                cajasFrontLadron[i][j].makeInvisible();
           }
       }
       ok=true;
   }
   /**
    * Este método termian el simulador.
    */
    public void finish(){
        System.exit(0);
   }
   /**
    * Este método retorna si la acción se pudo realizar o no.
    * 
    */
   public boolean ok(){
       return ok;
    }
}

