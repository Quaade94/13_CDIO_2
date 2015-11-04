package Spil;

public class Spiller {

	Spilleplade Plade = new Spilleplade();

	private int Player1Scorre = 1000;
	private int Player2Scorre = 1000;

	private int Player1Place = 0;
	private int Player2Place = 0;

	public void setPlayerPlace(boolean PlayerNr, int RollSum) {

		
		//System.out.println(PlayerNr);
		
		if (PlayerNr == true) {

//			System.out.println("Place Before roll " + Player1Place);
//			System.out.println("Roll " + RollSum);
			
			Player1Place = Player1Place + RollSum;

//			System.out.println("Place after roll " + Player1Place);
			
			if (Player1Place > 11) {

				Player1Place = Player1Place - 11;
			}
//			System.out.println("Place after -10  " + Player1Place);
		}else if (PlayerNr == false) {

//				System.out.println("Place Before roll " + Player2Place);
//				System.out.println("Roll " + RollSum);
				
				Player2Place = Player2Place + RollSum;

//				System.out.println("Place after roll " + Player2Place);
				
				if (Player2Place > 11) {

					Player2Place = Player2Place - 11;
				}
				
//				System.out.println("Place after -10  " + Player2Place);

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
		
//		System.out.println("Spiller = " + PlayerNr);
		
		if (PlayerNr == true){
			
			Player1Scorre = Player1Scorre + Plade.getFeltEffekt(Player1Place);
			if (Player1Scorre < 0){
				Player1Scorre = 0;
			}
			System.out.println(Plade.getFeltEffekt(Player1Place));
//			System.out.println(Player1Scorre);
		}else if (PlayerNr == false){
			
			Player2Scorre = Player2Scorre + Plade.getFeltEffekt(Player2Place);
			
			if (Player2Scorre < 0){
				Player2Scorre = 0;
			}
			
//			System.out.println(Plade.getFeltEffekt(Player2Place));
//			System.out.println(Player2Scorre);
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
