package Game;

public class Die {

	private int Dice1;
	private int Dice2;
	private boolean PreMode;
	
	

//	Roll metoden generere to terning slag fra 2 til 12
//	De bliver returneret som et array, hvor man kan tage dem ud hver for sig, eller bare summen af dem.
//	Ved at ex. at skrive int[] roll = Roll.Roll();  , og derefter int dice1 = roll[0], defineres den ene ternings værdi, roll[1] giver den anden ternings værdi
//	Ved at skrive roll[2], fås bare summen af terningslaget. Alt kommer ud som int'er.
//	
//	Kort eksempel på at bruge den:
//	
//		public static void main(String[] args) {
//	
//		Terninger Roll = new Terninger();
//
//		int[] roll = Roll.Roll();
//
//		System.out.println("Du slog: " + roll[0] + " og " + roll[1] + " summen er " + roll[2]);
//	}
		
	public void setPreDiceMode (boolean SetMode){
		
		PreMode = SetMode;
		
	}
	
	public void setPreDiceValue (int D1, int D2){
		
		Dice1 = D1;
		Dice2 = D2;
		
	}
	
	
	

	public int[] Roll() {

		int [] Roll = {0,0,0};

		
		
		if (PreMode == true) {
			
			
			Roll [0] = Dice1;
			Roll [1] = Dice2;
			
			int Sum = Dice1 + Dice2;
			
			Roll [2] = Sum;
		
		}
		
		if (PreMode == false){
			
			Dice1 = (int) (Math.random() * 6) + 1;
			Dice2 = (int) (Math.random() * 6) + 1;

			int Sum = Dice1 + Dice2;
			
			Roll [0] = Dice1;
			Roll [1] = Dice2;
			Roll [2] = Sum;
			
		}
		
		return Roll;
	}
}
