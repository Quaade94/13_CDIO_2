package Game;

public class Player {

	GameBoard Plade = new GameBoard();

	private int Player1Scorre = 1000;
	private int Player2Scorre = 1000;

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
		
		int ReturElement = -1;
		
		if (PlayerNr == true){
			
			ReturElement = Player1Place;
		}else if (PlayerNr == false){
			
			ReturElement = Player2Place;
		}else {
			System.out.println("Fejl i public class Spiller: getPlayerPlace");
		}

		return ReturElement;
	}
	
	public void setPlayerScorre (boolean PlayerNr){
		
		if (PlayerNr == true){
			
			Player1Scorre = Player1Scorre + Plade.getFieldEffect(Player1Place);
			if (Player1Scorre < 0){
				Player1Scorre = 0;
			}
			
		}else if (PlayerNr == false){
			
			Player2Scorre = Player2Scorre + Plade.getFieldEffect(Player2Place);
			
			if (Player2Scorre < 0){
				Player2Scorre = 0;
			}
		}
	}
	public int getPlayerScorre(boolean PlayerNr){
		
		int ReturElement = 0;
		
		if (PlayerNr == true){
						
			ReturElement = Player1Scorre;
			
		}else if (PlayerNr == false){

			ReturElement = Player2Scorre;
			
		}
		return ReturElement;
	}
	
}
