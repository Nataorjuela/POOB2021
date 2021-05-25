package domain;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class automataCelularTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class automataCelularTest
{
    private AutomataCelular  automata;
    private Celula indiana;
    private Celula oo7;
    /**
     * Default constructor for test class automataCelularTest
     */
    public automataCelularTest()
    {
        // AutomataCelular automata= new AutomataCelular();
        // Celula indiana=new Celula(automata,1,1);
        // Celula oo7=new Celula(automata,2,2);
        // automata.setElemento(1, 1, indiana);
        // automata.setElemento(2, 2, oo7);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }
    
    @Test
    public void tictacDeberiafuncionar(){
        AutomataCelular automata= new AutomataCelular();
        Celula indiana=new Celula(automata,1,1);
        automata.ticTac();
        automata.ticTac();
        automata.ticTac();
        assertEquals(indiana.getEdad(),3);
    } 
}
