package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import Game.Die;
import Game.DieTest;
import Game.GUI;
import Game.GameBoard;
import Game.Language;
import Game.Player;

public class GameTest{
	static GUI testgame = new GUI();
	Player game = new Player();
	GameBoard field = new GameBoard();
	Language language = new Language();
	static Die dice = new DieTest();

	
	public static void main(String[] args) {
		testgame.setRoll(dice);

	
	}
		
		@Test 
		public void testLandOnField(){
			
			int ForventetNytSted = 8;
			
			int[] Roll = dice.roll();
			
			game.setPlayerPlace(false, Roll[2]);
			
			assertEquals(game.getPlayerPlace(false), ForventetNytSted);
		}
		
		@Test
		public void testNegativePoint(){

			while (game.getPlayerScore(true) > 0) {

				int[] Roll = dice.roll();
				game.setPlayerPlace(true, Roll[2]);
				while (field.getFieldEffect(game.getPlayerPlace(true)) > 0) {
					Roll = dice.roll();
					game.setPlayerPlace(true, Roll[2]);
				}

				game.setPlayerScore(true);
			}
			assertTrue(game.getPlayerScore(true) <= 0);
		}
		

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
	


// Ronni: test occurenses (dices, fields), ?


	