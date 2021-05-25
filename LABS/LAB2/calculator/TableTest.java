import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author   ECI
 * @version 2021-1
 */
public class TableTest
{
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        
    }
 
    @Test    
    public void shouldPass(){
        assertTrue(true);
    }
    
    @Test
    public void shouldFail(){
        assertTrue(false);
    }

    @Test    
    public void shouldErr(){
        int[] x={1,2,3};
        int[] y={};
        for (int i=0; i<3;i++){
            assertEquals(x[i],y[i]);
        }
    }

     @Test
    public void shouldCreateAnEmptyTables(){
        String [] attributes={"SIGLA","NOMBRE"};
        Table courses=new Table(attributes);
        assertEquals(0,courses.size());
        assertArrayEquals(attributes,courses.attributes());
    }
    
    @Test
    public void shouldCreateTables(){
        String [] attributes={"SIGLA","NOMBRE"};
        String [][] data={{"POOB","Programacion orientada a objetos"},{"MBDA", "Modelos y bases de datos"}};
        Table courses=new Table(attributes);
        courses.insert(data);
        assertEquals(2,courses.size());
        assertTrue(courses.in(data[0]));
        assertTrue(courses.in(data[1]));
    }

    @Test
    public void shouldNotInsertBadTuples(){
        String [] attributes={"SIGLA","NOMBRE"};
        String [][] data={{"POOB","Programacion orientada a objetos"},{"POOB","Programacion orientada a objetos"}};
        Table courses=new Table(attributes);
        courses.insert(data);
        assertEquals(3,courses.size());
    }    
        
    @Test
    public void shouldRepresentTableAsString(){
        String [] attributes={"first","second","third"};
        String [][] data={{"x","x","x"},{"b","c",""},{"b","f","g"},{"d","d","d"},{"a","b","x"},{"a","b","c"}};
        Table example=new Table(attributes);
        example.insert(data);
        String result="[FIRST,SECOND,THIRD)\n(x,x,x)\n(b,c,)\n(b,f,g)\n(d,d,d)\n(a,b,x)\n(a,b,c)\n";
        assertEquals(result,example.toString()); 
    }
    @Test
    public void shouldProyectionGood(){
       String [] attributes={"nombres","apellidos","celular"};
       String [][] data={{"Diego","Macana","123"},{"Nata","Orjuela","456"},{"Laura","Herrera","9"}}; 
       Table example=new Table(attributes);
       example.insert(data);
       String [] attributes2={"nombres","celular"};
       String [][] data2={{"Diego","123",},{"Nata","456"},{"Laura","9"}}; 
       Table example2=new Table(attributes2);
       example2.insert(data2);
       assertEquals(example2.toString(),example.proyection(attributes2).toString());
    }
    @Test
    public void shouldSeleccionGood(){
       String [] attributes={"nombres","apellidos","celular"};
       String [][] data={{"Diego","Macana","123"},{"Nata","Orjuela","456"},{"Laura","Herrera","123"}}; 
       Table example=new Table(attributes);
       example.insert(data);
       String [] attributes2={"nombres","apellidos","celular"};
       String [][] data2={{"Diego","Macana","123"},{"Laura","Herrera","123"}}; 
       Table example2=new Table(attributes2);
       example2.insert(data2);
       
       assertEquals(example2.toString(),example2.selection("celular","123").toString());
    }
    @Test
    public void shouldMostrar(){
       String [] attributes={"nombres","apellidos","celular"};
       String [][] data={{"Diego","Macana","123"},{"Nata","Orjuela","456"},{"Laura","Herrera","123"}}; 
       Table example=new Table(attributes);
       example.insert(data);
       example.mostrar();
    }
    @Test
    public void shouldChangeName(){
       String [] attributes={"nombres","apellidos","celular"};
       String [][] data={{"Diego","Macana","123"},{"Nata","Orjuela","456"},{"Laura","Herrera","123"}}; 
       Table example=new Table(attributes);
       example.insert(data);
       
       String [] attributes2={"nicks","lastnames","phones"};
       Table example2=new Table(attributes2);
       example2.insert(data);
       assertEquals(example2.toString(),example.rename(attributes2).toString());
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
