package Game;

public class GameBoard {

	Language lang = new Language();
	private int[] fields = { 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650 };
	private String[] fieldName = { lang.lang()[14], lang.lang()[15], lang.lang()[16], lang.lang()[17], lang.lang()[18], lang.lang()[19], lang.lang()[20], lang.lang()[21], lang.lang()[22], lang.lang()[23], lang.lang()[24] };
	

	public int getFieldEffect(int playerField) {

		return fields[playerField-1];
	}

	public String getFieldName(int playerField) {

		return fieldName[playerField-1];
	}

}