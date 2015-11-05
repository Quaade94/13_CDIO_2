package Game;

public class Player {

	GameBoard Plade = new GameBoard();

	private int player1Score = 1000;
	private int player2Score = 1000;

	private int player1Place = 0;
	private int player2Place = 0;

	public void setPlayerPlace(boolean playerNr, int rollSum) {

		
		if (playerNr == true) {
			
			player1Place = player1Place + rollSum;
			
			if (player1Place > 11) {

				player1Place = player1Place - 11;
			}
			
		}else if (playerNr == false) {
				
				player2Place = player2Place + rollSum;
				
				if (player2Place > 11) {

					player2Place = player2Place - 11;
				}
			}	
	}
	
	public int getPlayerPlace(boolean playerNo){
		
		int returnElement = -1;
		
		if (playerNo == true){
			
			returnElement = player1Place;
		}else if (playerNo == false){
			
			returnElement = player2Place;
		}else {
			System.out.println("Fejl i public class Spiller: getPlayerPlace");
		}

		return returnElement;
	}
	
	public void setPlayerScorre (boolean playerNo){
		
		if (playerNo == true){
			
			player1Score = player1Score + Plade.getFieldEffect(player1Place);
			if (player1Score < 0){
				player1Score = 0;
			}
			
		}else if (playerNo == false){
			
			player2Score = player2Score + Plade.getFieldEffect(player2Place);
			
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
