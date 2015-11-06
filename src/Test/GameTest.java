package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Game.Die;
import Game.GUI;
import Game.GameBoard;
import Game.Language;
import Game.Player;

public class GameTest {

	GUI testgame = new GUI();
	Player game = new Player();
	GameBoard field = new GameBoard();
	Language language = new Language();
	Die dice = new Die();
	{
	testgame.setRoll(dice);
	
	
	}
//	@Test
////	public void testNegativePoint() {
////		game.setPlayerScorre(true);
////		field.getFeltEffekt(5);
////		game.setPlayerScorre(true);
////		int retur = game.getPlayerScorre(true);
////		System.out.println("1 "+retur);
////		System.out.println("2 "+field.getFeltEffekt(5));
//		
//	}
	
//	@Test 
//	public void testOccurencesDices(){
//		int diceroll = dice.Roll()[2];
////		sleep
//		System.out.println("dice "+diceroll);
//	}
	
	@Test 
	public void testPreDices(){
		
		dice.setPreDiceMode(true);
		dice.setPreDiceValue(4, 4);
		
		int[] expected = {4,4,8};
		
		int[] actual = dice.roll();
		
//		System.out.println(" Værdi 1 " + Forv[0] + " Værdi 2 " + Forv[1] +" Værdi 3 " + Forv[2] + " end");
//		System.out.println(" Værdi 1 " + Roll[0] + " Værdi 2 " + Roll[1] +" Værdi 3 " + Roll[2] + " end");

		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);
		assertEquals(expected[2], actual[2]);
		
		dice.setPreDiceMode(false);
		
	}
	
	@Test 
	public void testLandOnField(){
		
		
//		Spiller 1 test:
		
		
		int d1 = 4;
		int d2 = 5;
		int expectedNewPlace = d1 + d2;
		
		dice.setPreDiceMode(true);
		dice.setPreDiceValue(d1, d2);
		
		int [] roll = dice.roll();
		
		game.setPlayerPlace(true, roll[2]);
		
//		System.out.println("Nyt spiller sted = " + game.getPlayerPlace(true) + " Forventede sted = " + ForventetNytSted);
		
		assertEquals(game.getPlayerPlace(true), expectedNewPlace);
				
		dice.setPreDiceMode(false);
		

//		Spiller 2 test:
				
		d1 = 5;
		d2 = 6;
		expectedNewPlace = d1 + d2;
		
		dice.setPreDiceMode(true);
		dice.setPreDiceValue(d1, d2);
		
		roll = dice.roll();
		
		game.setPlayerPlace(false, roll[2]);
		
//		System.out.println("Nyt spiller sted = " + game.getPlayerPlace(false) + " Forventede sted = " + ForventetNytSted);
		
		assertEquals(game.getPlayerPlace(false), expectedNewPlace);
				
		dice.setPreDiceMode(false);
		
	}
		
}
// Ronni: test occurenses (dices, fields), ?


	