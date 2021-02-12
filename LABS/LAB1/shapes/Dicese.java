
/**
 * Write a description of class Dicese here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   
public class Dicese
   {
    private Dice[] dados;
    private boolean isVisible;
    private int n;
    private boolean win;
    private int juegos;
    private int ganados;
    
   /**
     * Constructor for objects of class Dicese
     * @parameter n int cantidad de dados
     */
    public Dicese(int n)
    {
       isVisible=false;
       dados=new Dice[6];
       dados[0]=new Dice();
       juegos=0;
       int distancia=0;
       this.n=n;
       for(int i=0;i<n;i++){
           if(i>=1){
              dados[i]=new Dice();
              distancia+=100;
              dados[i].moveHorizontal(50+distancia);
              distancia+=50;
            }
        }
    }
    /**
     * metodo para reiniciar el porcentaje de victoria de un juego
     * 
     */
   public void reset()
   {
       juegos=0;
       ganados=0;
     
    }
    /**
     * devuelve el numero de juegos ganados
     * @return ganados es un numero de las partidas ganadas
     */
    public int getGanados()
    {
      return ganados;
    }
    /**
     * metodo para mover vertical una fila de dados
     * 
     */
   public void moveVertical(){
     int distancia=100;
       for(int i=0;i<n;i++){
          
          dados[i].moveVertical(50+distancia);
           
        }
    
    }
    /**
     * metodo para cambiar color de los dados de un juego ganado
     * 
     */
    public void superWin()
    {
      for(int i=0;i<n;i++)
       {
           dados[i].superWin();
       }
    }
    /**
     * metodo para jugar con una fila de dados
     * 
     */
   public void play()
   {
       
       for(int i=0;i<n;i++)
       {
           dados[i].roll();
           
       }
    }
    /**
     * metodo para descubrir si se gano en una fila de dados
     * @return win devuelve el booleano de si gano la fila o no.
     */
   public boolean resultadoFIl(){  
       int ganoA=1; 
       int ganoD=1;
       int cont=0;
       cont=dados[0].getValue();
       for(int i=1;i<n;i++)
       { 
        //System.out.println("comparamos "+cont+"contra"+dados[i].getValue());
        if(cont+1==dados[i].getValue())
        {
           ganoA+=1;
           //System.out.println("+");
           cont=dados[i].getValue();
        }
        else if(cont-1==dados[i].getValue())
        {
           ganoD+=1;
           //System.out.println("-");
           cont=dados[i].getValue();
        }
      }
       if (ganoA==n || ganoD==n) 
        {
            win=true;
            return win;
        }
        else
        {    
            win=false;
            return win;
        }
    }
    /**
     * metodo para jugar con un unico dado
     * @param x int valor de la columna a alterar el dado
     */
    public void playUnDado(int x){
        int num=1;
        for (int i=n-1;i>=0;i=i-1){
            if (x==num)
            {
                dados[i].roll();
            }
            num+=1;
        }
    }
    /**
     * metodo para jugar x veces
     * @param int times indica la cantidad de veces a jugar
     */
   public void play(int times)
   {
       juegos=times;
       for(int i=0;i<times;i++){
           play();
           if (isWinningStates()){
            ganados+=1;
           }
        }
   }
   /**
     * metodo para saber el porcentaje de victoria
     * @return porwin el porcentaje de victoria
     */
   public float percentageOfWinningStates(){
    float porwin=ganados*100/juegos;
    return porwin;
    }
   
   /**
   * Este método muestra el dado
   */
   public void makeVisible()
      {
       isVisible=true;
       for(int i=0;i<n;i++){
           dados[i].makeVisible();
        }
    }
    /**
     * metodo para saber si el juego esta ganado o no.
     */
    public boolean isWinningStates(){
        if (win){
        return true;
        }
        else{
        return false;
        }
    }
   /**
   * Este método oculta el dado
   */
    public void makeInvisible()
    {
        isVisible=false;
        for(int i=0;i<n;i++){
           dados[i].makeInvisible();
         }
    }
    /**
     * metodo para obtener un dado de la fila de dados
     * @param int fila parametro para indicar el numero de fila 
     */
    public int getDado(int columna){
        return dados[columna].getValue();
    }
}
 
