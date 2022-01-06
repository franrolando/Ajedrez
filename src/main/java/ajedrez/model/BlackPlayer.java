package ajedrez.model;

public class BlackPlayer extends Player {

	public BlackPlayer(PlayerE playerMood) {
		super(playerMood);
	}

	@Override
	public Boolean isWhitePlayer() {
		return false;
	}

}
