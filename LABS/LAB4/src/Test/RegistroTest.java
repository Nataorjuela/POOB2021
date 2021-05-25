package Test;

import aplicacion.SINAPExcepcion;
import aplicacion.Sinap;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistroTest {

    @Test
    public void DeberiaInsertarArea() {
        Sinap area=new Sinap();
        try{
         area.adicione("Mundo Aventura","Adventure World","Colombia","469456","Parque de atracciones");
         assertEquals(1,area.numeroAreas());
        }
        catch(SINAPExcepcion e){fail();}
    }
    @Test
    public void NoDeberiaInsertarArea() {
    	 Sinap area=new Sinap();
         try{
          area.adicione("Mundo Aventura","Adventure World","Colombia","0","Parque de atracciones");
          assertEquals(0,area.numeroAreas());
         }
         catch(SINAPExcepcion e){fail();}
     }
   
}
