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
		
		int[] Forv = {4,4,8};
		
		int[] Roll = dice.Roll();
		
//		System.out.println(" Værdi 1 " + Forv[0] + " Værdi 2 " + Forv[1] +" Værdi 3 " + Forv[2] + " end");
//		System.out.println(" Værdi 1 " + Roll[0] + " Værdi 2 " + Roll[1] +" Værdi 3 " + Roll[2] + " end");

		assertEquals(Forv[0], Roll[0]);
		assertEquals(Forv[1], Roll[1]);
		assertEquals(Forv[2], Roll[2]);
		
		dice.setPreDiceMode(false);
		
	}
	
	@Test 
	public void testLandePaaFelt(){
		
		
//		Spiller 1 test:
		
		
		int D1 = 4;
		int D2 = 5;
		int ForventetNytSted = D1 + D2;
		
		dice.setPreDiceMode(true);
		dice.setPreDiceValue(D1, D2);
		
		int [] Roll = dice.Roll();
		
		game.setPlayerPlace(true, Roll[2]);
		
//		System.out.println("Nyt spiller sted = " + game.getPlayerPlace(true) + " Forventede sted = " + ForventetNytSted);
		
		assertEquals(game.getPlayerPlace(true), ForventetNytSted);
				
		dice.setPreDiceMode(false);
		

//		Spiller 2 test:
				
		D1 = 5;
		D2 = 6;
		ForventetNytSted = D1 + D2;
		
		dice.setPreDiceMode(true);
		dice.setPreDiceValue(D1, D2);
		
		Roll = dice.Roll();
		
		game.setPlayerPlace(false, Roll[2]);
		
//		System.out.println("Nyt spiller sted = " + game.getPlayerPlace(false) + " Forventede sted = " + ForventetNytSted);
		
		assertEquals(game.getPlayerPlace(false), ForventetNytSted);
				
		dice.setPreDiceMode(false);
		
	}
		
}
// Ronni: test occurenses (dices, fields), ?


	