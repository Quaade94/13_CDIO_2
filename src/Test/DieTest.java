package Test;

import Game.Die;

public class DieTest extends Die{

	@Override
	public int[] roll() {
		return new int[] {4, 4, 8};
	}

}
