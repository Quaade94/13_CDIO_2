package Game;

public class Die {

	private int dice1;
	private int dice2;
	
	public int[] roll() {

		int [] roll = {0,0,0};

			dice1 = (int) (Math.random() * 6) + 1;
			dice2 = (int) (Math.random() * 6) + 1;

			int sum = dice1 + dice2;
			
			roll [0] = dice1;
			roll [1] = dice2;
			roll [2] = sum;
		
		return roll;
	}
}
