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


	