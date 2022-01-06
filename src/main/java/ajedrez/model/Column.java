package ajedrez.model;

public enum Column {

	A(0, "A"), B(1, "B"), C(2, "C"), D(3, "D"), E(4, "E"), F(5, "F"), G(6, "G"), H(7, "H");

	private int num;
	private String letter;

	private Column(int num, String letter) {
		this.num = num;
		this.letter = letter;
	}

	public int getValue() {
		return this.num;
	}

	public String getLetter() {
		return this.letter;
	}

	public static Column findByAbbr(String abbr) {
		for (Column v : values()) {
			if (v.getLetter().equals(abbr.toUpperCase())) {
				return v;
			}
		}
		return null;
	}

}
