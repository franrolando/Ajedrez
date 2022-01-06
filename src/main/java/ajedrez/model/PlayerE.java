package ajedrez.model;

public enum PlayerE {

	COMPUTER("X"), USER("O");

	private PlayerE(String text){
		this.text = text;
	}

	private final String text;

	public String toString() {
		return text;
	}
}
