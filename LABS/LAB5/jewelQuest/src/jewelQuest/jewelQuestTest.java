package jewelQuest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class jewelQuestTest {



	@Test
	public void Deberia() 
	{
		JewelQuest gui=new JewelQuest();
		gui.cambiar(0, 0, 1, 0);
		assertTrue(gui.getPuntaje()>0);
		



	}
}
