package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import Game.Die;
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
		
		
		@Test
		public void testLandAllFields(){
			Die dice2 = new Die();
			testgame.setRoll(dice2);
			boolean fieldDone = false;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			int f = 0;
			int g = 0;
			int h = 0;
			int i = 0;
			int j = 0;
			int k = 0;
			while (fieldDone == false) {

				int[] Roll = dice.roll();
				game.setPlayerPlace(true, Roll[2]);
				if (game.getPlayerPlace(true) == 1) {
					a = 1;
				} else if (game.getPlayerPlace(true) == 2) {
					b = 1;
				} else if (game.getPlayerPlace(true) == 3) {
					c = 1;
				} else if (game.getPlayerPlace(true) == 4) {
					d = 1;
				} else if (game.getPlayerPlace(true) == 5) {
					e = 1;
				} else if (game.getPlayerPlace(true) == 6) {
					f = 1;
				} else if (game.getPlayerPlace(true) == 7) {
					g = 1;
				} else if (game.getPlayerPlace(true) == 8) {
					h = 1;
				} else if (game.getPlayerPlace(true) == 9) {
					i = 1;
				} else if (game.getPlayerPlace(true) == 10) {
					j = 1;
				} else if (game.getPlayerPlace(true) == 11) {
					k = 1;
				}
				if (a == 1 && b == 1 && c == 1 && d == 1 && e == 1 && f == 1 && g == 1 && h == 1 && i == 1 && j == 1 && k == 1) {
					fieldDone = true;
				}
			}
			assertTrue(fieldDone == true);
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


	