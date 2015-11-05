package Game;

public class Game_board {

	Language X = new Language();
	private int[] Fields = { 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650 };
	private String[] FieldName = { X.lang()[14], X.lang()[15], X.lang()[16], X.lang()[17], X.lang()[18], X.lang()[19], X.lang()[20], X.lang()[21], X.lang()[22], X.lang()[23], X.lang()[24] };
	

	public int getFieldEffect(int playerField) {

		return Fields[playerField-1];
	}

	public String getFieldName(int playerField) {

		return FieldName[playerField-1];
	}

}