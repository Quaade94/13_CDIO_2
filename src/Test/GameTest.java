package Test;

import static org.junit.Assert.assertEquals;

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
	Die dice = new DieTest();
	{
	testgame.setRoll(dice);
	
	
	}
	
	public static void main(String[] args) {


	
	}
		
		@Test 
		public void testLandePaaFelt(){
			
			int ForventetNytSted = 8;
			
			int[] Roll = dice.roll();
			
			game.setPlayerPlace(false, Roll[2]);
			
			assertEquals(game.getPlayerPlace(false), ForventetNytSted);
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


	