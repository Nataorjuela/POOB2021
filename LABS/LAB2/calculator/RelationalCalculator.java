import java.util.Stack;

/** Calculator.java
 * @author ESCUELA 2021-1
 */
    
public class RelationalCalculator{

    private Stack<Table> tables;
    //Consultar en el API Java la clase Stack
    
    public RelationalCalculator(){
        tables=new Stack<Table>();
    }
    public void add(String [] attributes){  
        tables.push(new Table(attributes));
    }
    public void add(String [] attributes, String[][] tuples){       
        add(attributes);
        for(int i=0;i<tuples.length;i++){
            add(tuples[i]);
        }
    }
    public int size(){
        return tables.size();
    }
    /*Consult the top of the stack*/
    public String consult(){
        Table top=tables.peek();
        return (top.toString());
    }
    
    public void delete(){
    }
    
 
    public void insert(String[][] tuples){       
    }  
    
    /*
    * set operation: 'u' (union), 'i' (intersection), 'd' (difference)
    * relational operation:  'p' (projection), 's' (selection), 'j' (natural join) , 'r' (rename)
    * To project and rename, the attributes are at the top of the stack.
    + To select, the attributes and values are at the top of the row.  
    * If the operation cannot be done, the stack is not modified.
    */
    public void calculate(char operator){
    }
    
    /*Indicates if the last action was successful*/
    public boolean ok(){
        return false;
    }
}
    



