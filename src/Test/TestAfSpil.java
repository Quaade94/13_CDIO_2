package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Spil.GUI;
import Spil.Spiller;
import Spil.Spilleplade;
import Spil.Language;

public class TestAfSpil {

	GUI testspil = new GUI();
	Spiller spil = new Spiller();
	Spilleplade plade = new Spilleplade();
	Language language = new Language();
	
	@Test
	public void testAfNegativePoint() {
		plade.getFeltEffekt(5);
		spil.setPlayerScorre(true);
		int retur = spil.getPlayerScorre(true);
		System.out.println("1 "+retur);
		
	}

}
