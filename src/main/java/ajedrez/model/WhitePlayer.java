package ajedrez.model;

public class WhitePlayer extends Player {

	public WhitePlayer(PlayerE playerMood) {
		super(playerMood);
	}

	@Override
	public Boolean isWhitePlayer() {
		return true;
	}

}
