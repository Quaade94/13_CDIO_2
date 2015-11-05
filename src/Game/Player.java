package Game;

public class Player {

	GameBoard Plade = new GameBoard();

	private int player1Score = 1000;
	private int player2Score = 1000;

	private int Player1Place = 0;
	private int Player2Place = 0;

	public void setPlayerPlace(boolean PlayerNr, int RollSum) {

		
		if (PlayerNr == true) {
			
			Player1Place = Player1Place + RollSum;
			
			if (Player1Place > 11) {

				Player1Place = Player1Place - 11;
			}
			
		}else if (PlayerNr == false) {
				
				Player2Place = Player2Place + RollSum;
				
				if (Player2Place > 11) {

					Player2Place = Player2Place - 11;
				}
			}	
	}
	
	public int getPlayerPlace(boolean PlayerNr){
		
		int returnElement = -1;
		
		if (PlayerNr == true){
			
			returnElement = Player1Place;
		}else if (PlayerNr == false){
			
			returnElement = Player2Place;
		}else {
			System.out.println("Fejl i public class Spiller: getPlayerPlace");
		}

		return returnElement;
	}
	
	public void setPlayerScorre (boolean playerNo){
		
		if (playerNo == true){
			
			player1Score = player1Score + Plade.getFieldEffect(Player1Place);
			if (player1Score < 0){
				player1Score = 0;
			}
			
		}else if (playerNo == false){
			
			player2Score = player2Score + Plade.getFieldEffect(Player2Place);
			
			if (player2Score < 0){
				player2Score = 0;
			}
		}
	}
	public int getPlayerScorre(boolean playerNo){
		
		int returnElement = 0;
		
		if (playerNo == true){
						
			returnElement = player1Score;
			
		}else if (playerNo == false){

			returnElement = player2Score;
			
		}
		return returnElement;
	}
	
}
