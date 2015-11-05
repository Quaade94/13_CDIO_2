package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Spil.GUI;
import Spil.Spiller;
import Spil.Spilleplade;
import Spil.Language;
import Spil.Terninger;

public class TestAfSpil {

	GUI testgame = new GUI();
	Spiller game = new Spiller();
	Spilleplade field = new Spilleplade();
	Language language = new Language();
	Terninger dice = new Terninger();
	
//	@Test
//	public void testNegativePoint() {
//		game.setPlayerScorre(true);
//		field.getFeltEffekt(5);
//		game.setPlayerScorre(true);
//		int retur = game.getPlayerScorre(true);
//		System.out.println("1 "+retur);
//		System.out.println("2 "+field.getFeltEffekt(5));
//		
//	}
	
	@Test
	public void testOccurencesDices(){
		int diceroll = dice.Roll()[2];
//		sleep
		System.out.println("dice "+diceroll);
	}

}
// Ronni: test occurenses (dices, fields), ?