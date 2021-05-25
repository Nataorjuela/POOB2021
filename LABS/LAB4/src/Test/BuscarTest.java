package Test;


import aplicacion.SINAPExcepcion;
import aplicacion.Sinap;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuscarTest {
	@Test
	public void DeberiaBuscarArea() {
		
	    Sinap area=new Sinap();

	    try {
			area.adicione("Mundo Aventura","Adventure World","Colombia","469456","Parque de atracciones");
		} catch (SINAPExcepcion e) {}
	    try {
			assertEquals(1,area.busque("M").size());
		} catch (SINAPExcepcion e) {} 

	}
}
