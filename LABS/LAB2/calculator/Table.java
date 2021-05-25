import java.util.Arrays;
import java.util.ArrayList;
/**
 * @author Natalia Orjuela, Diego Macana
 * @version 18 de febrero 20201
 *
 */
public class Table{
    private String[] attributes;
    private ArrayList<String[]> tuples;
    /*
     * The tables must remain 
     * (i) with the attribute names in uppercase 
     * (ii) without repeating tuples*/
    /**
     * Constructs a new, empty table, with the specified attribute names.
     * @param names, 
    **/
    public Table(String attributes[]){
        this.attributes=attributes;
        tuples = new ArrayList();        
    }    
    /**
     * Inserts the specified tuples to this table 
     * @param tuples, 
    **/
    public void insert(String tuples1[][]) {
        for (int i=0;i<tuples1.length;i++)
        {
            if (tuples.contains(tuples1[i])){
                System.out.println("elementos repetidos");
                System.exit(0);
            }
            else{
                 tuples.add(tuples1[i]);
            }
        }
    }
    /**
     * Devuelve la longitud de los datos de la tabla
     * @return int 
     * 
    **/
    public int size(){
        return tuples.size();
    }
    /**
     * Devuelve una lista de los nombres de los atributos
     * @return String[]
     * 
    **/
    public String[] attributes(){
        return attributes;
    }
    public String[] tuple(int n){
        return null;
    }
    /**
     * Devuelve booleano si una lista de datos esta dentro de nuestros datos
     * @return boolean 
     * @param String tuple[] array que contiene una lista de datos
    **/
    public boolean in(String tuple[]){
        return tuples.contains(tuple);
    }    
    /**
     * Devuelve la tabla con unos atributos especificados
     * @return Table proyeccion 
     * @param String attributes1[] lista de strings con los atributos 
    **/
    public Table proyection(String attributes1[]){
        Table proyeccion=new Table(attributes1);
        String [][] matriz= new String[tuples.size()][attributes1.length];
        int conta=0;
        int conta2=0;
        for (int i=0;i<attributes.length;i++)
        {
            conta2=0;
            for (int j=0;j<tuples.size();j++)
            {      
                if (attributes[j]==attributes1[conta2]){  
                    matriz[conta][conta2]=tuples.get(i)[j];
                    conta2+=1;
                }
            }
            conta+=1;
        }
        proyeccion.insert(matriz);
        return proyeccion;
    }
    /**
     * Devuelve la tabla con unos atributos especificados y datos especificados
     * @return Table seleccion
     * @param String attribute string con el atributo y String value con el valor
    **/
    public Table selection(String attribute, String value){
        Table seleccion=new Table(attributes);
        String[][] matriz= new String[tuples.size()][attributes.length];
        for (int i=0;i<tuples.size();i++){
            for(int j=0;j<attributes.length;j++)
            {
                if (attributes[j]==attribute && tuples.get(i)[j]==value){
                 
                    String[] array=tuples.get(i);
                    matriz[i]=array;
                }
            }
        }
        seleccion.insert(matriz);
        return seleccion;
    }    
    public Table naturalJoin(Table t){
        return null;
    }
    /**
     * Devuelve la tabla con unos atributos renombrados
     * @return Table nuevo
     * @param String[] newAttributes 
    **/
    public Table rename(String[] newAttributes){
        Table nuevo=new Table(newAttributes);
        String[][] matriz= obtenerTuples();
        nuevo.insert(matriz);
        return nuevo;
    }
    /**
     * Devuelve las tuplas tranformadas en matriz
     * @return Srting[][] matriz
     * 
    **/
    private String[][] obtenerTuples(){
        String[][] matriz= new String[tuples.size()][attributes.length];
        for (int i=0;i<tuples.size();i++){
            for (int j=0;j<tuples.get(i).length;j++){matriz[i][j]=tuples.get(i)[j];}}
        return matriz;
    }
    /*
     * Set operators
     * The two relations involved must be union-compatible—that is, the two relations must have the same set of attributes.
     */
    public Table union(Table t){
        return null;
    }
    public Table intersection(Table t){
       return null;
    }  
    public Table difference(Table t){
       return null;        
    }
    /**
     * muestra los datos y atributos de la clase table
    **/
    public void mostrar()
    {
        for (int i=0;i<attributes.length;i++){System.out.print(attributes[i]+"   ");}
        System.out.println();
        for (int i=0;i<attributes.length;i++){for (int j=0;j<tuples.size();j++){System.out.print(tuples.get(i)[j]+"       ");}System.out.println();}
    }
    
    /**
     * Indicates whether some other table is "equal to" this one.
     * @param t the table with which to compare.
     */
    private boolean equals (Table t) {
        return false;
    }    
    
    @Override
    public boolean equals (Object o) {
            return this.equals ((Table) o);
    }
    /**
     * Devuelve un string con la tabla 
     * @return String s
     * 
    **/
    @Override
    public String toString () {
          String s = "[";
          for (int i=0; i<attributes.length;i++ )
          {
              s+=attributes[i].toUpperCase();
              if (i !=(attributes.length -1)){s+=",";}             
          }
          s+=")";
          for (int i=0; i<tuples.size();i++ )
          {
            s +="\n(";
              for(int j=0;j<tuples.get(i).length;j++){
              s+=tuples.get(i)[j];
              if (j !=(tuples.get(i).length-1)){s+=",";} 
            }
            s+=")";
          }
          s+="\n";
          System.out.println(s);
          return s;
    }
}
