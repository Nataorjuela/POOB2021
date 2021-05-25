import java.util.ArrayList;
/**
 * Write a description of class Perecedero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Perecedero extends Product
{
    // instance variables - replace the example below with your own
    private ArrayList<Lote> lotes;

    /**
     * Constructor for objects of class Perecedero
     */
    public Perecedero()
    {
        
    }
    public void unitsSold(int units) {
     }
    public int available() throws GinkoException{
        int cont=0;
        for(int i=0;i<lotes.size();i++){
         cont=lotes.get(i).getExistencias();
         if (lotes.get(i).getExistencias()<0){
           throw new GinkoException(GinkoException.PRICE_PROBLEM);    
          }
        }
       return cont;
     }
}
