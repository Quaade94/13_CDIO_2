package Spil;

public class Spiller {

	Spilleplade Plade = new Spilleplade();

	private int Player1Scorre = 1000;
	private int Player2Scorre = 1000;

	private int Player1Place = 0;
	private int Player2Place = 0;

	public void setPlayerPlace(int PlayerNr, int OldPlace, int RollSum) {

		if (PlayerNr == 1) {

			Player1Place = OldPlace + RollSum;

			if (Player1Place > 10) {

				Player1Place = Player1Place - 10;
			}

		}
		if (PlayerNr == 2) {

			Player2Place = OldPlace + RollSum;

			if (Player2Place > 10) {

				Player2Place = Player2Place - 10;
			}
		} else {
			System.out.println("Fejl i public class Spiller: setPlayerPlace");
		}
	}
	
	public int getPlayerPlace(int PlayerNr){
		
		int ReturElement = -1;
		
		if (PlayerNr == 1){
			
			ReturElement = Player1Place;
		}
		if (PlayerNr == 2){
			
			ReturElement = Player2Place;
		}
		else {
			System.out.println("Fejl i public class Spiller: getPlayerPlace");
		}

		return ReturElement;
	}
	
	public void setPlayerScorre (int PlayerNr){
		
		if (PlayerNr == 1){
			
			Player1Scorre = Player1Scorre + Plade.getFeltEffekt(Player1Place);
			
		}
		if (PlayerNr == 2){
			
			Player2Scorre = Player2Scorre + Plade.getFeltEffekt(Player2Place);
			
		}
	}
	public int getPlayerScorre(int PlayerNr){
		
		int ReturElement = 0;
		
		if (PlayerNr == 1){
			
			ReturElement = Player1Scorre;
			
		}
		if (PlayerNr == 2){
			
			ReturElement = Player2Scorre;
			
		}
		return ReturElement;
	}
	
	
	
	
	
	
	
	

}
