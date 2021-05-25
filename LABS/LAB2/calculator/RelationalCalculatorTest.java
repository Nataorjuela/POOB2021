

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RelationalCalculatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RelationalCalculatorTest
{
   private RelationalCalculator calculator;
   /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        calculator= new RelationalCalculator();
    }
    @Test
    public void DeberiaInsertar(){
        String [] attributes={"SIGLA","NOMBRE"};
        String [][] data={{"POOB","Programacion orientada a objetos"},{"MBDA", "Modelos y bases de datos"}};
        calculator.add(attributes,data);
        assertEquals(3,calculator.size());
   }
   @Test
   public void DeberiaConsultar(){
        String [] attributes={"MATERIA","PROFESOR"};
        calculator.add(attributes);
        assertEquals(1,calculator.size());
        String result="[MATERIA,PROFESOR)\n";
        assertEquals(result,calculator.consult());
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
