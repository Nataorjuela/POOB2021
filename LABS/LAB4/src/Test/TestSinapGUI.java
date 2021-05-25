package Test;

import presentacion.SinapGUI;
import org.junit.Test;

import aplicacion.Sinap;

import static org.junit.Assert.*;

public class TestSinapGUI {
    @Test
    public void DeberiaInsertarAreas() {
     SinapGUI interfaz=new SinapGUI();
     Sinap x= interfaz.getAreas();
     assertEquals(6,x.numeroAreas());
 }

}