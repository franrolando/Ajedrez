package ajedrez.model;

import java.util.List;

public abstract class Player {

	private List<Piece> pieces;
	private PlayerE playerMood;

	public Player(PlayerE playerMood) {
		this.playerMood = playerMood;
	}
	
	public abstract Boolean isWhitePlayer();

	public List<Piece> getPieces() {
		return pieces;
	}

	public PlayerE getPlayerMood() {
		return playerMood;
	}

	public void setPieces(List<Piece> wihtePlayerPieces) {
		this.pieces = wihtePlayerPieces;
		orderMyPieces();
		this.pieces.stream().forEach(piece -> piece.setPlayer(this));
	}


	private void orderMyPieces() {
		int row = isWhitePlayer() ? 1 : 6;
		for (int i = 0; i < PieceAmount.PAWN.getAmount(); i++) {
			Piece pawn = this.pieces.get(i);
			pawn.setPosition(row, i);
		}
		row = isWhitePlayer() ? row - 1 : row + 1;
		for (int i = PieceAmount.PAWN.getAmount(); i < PieceAmount.PAWN.getAmount()
				+ PieceAmount.ROOK.getAmount(); i++) {
			Piece tower = this.pieces.get(i);
			tower.setPosition(isWhitePlayer() ? 0 : 7, i % 2 == 0 ? 0 : 7);
		}
		for (int i = PieceAmount.PAWN.getAmount() + PieceAmount.ROOK.getAmount(); i < PieceAmount.PAWN.getAmount()
				+ PieceAmount.ROOK.getAmount() + PieceAmount.HORSE.getAmount(); i++) {
			Piece knight = this.pieces.get(i);
			knight.setPosition(isWhitePlayer() ? 0 : 7, i % 2 == 0 ? 1 : 6);
		}
		for (int i = PieceAmount.PAWN.getAmount() + PieceAmount.ROOK.getAmount()
				+ PieceAmount.HORSE.getAmount(); i < PieceAmount.PAWN.getAmount() + PieceAmount.ROOK.getAmount()
						+ PieceAmount.HORSE.getAmount() + PieceAmount.BISHOP.getAmount(); i++) {
			Piece bishop = this.pieces.get(i);
			bishop.setPosition(isWhitePlayer() ? 0 : 7, i % 2 == 0 ? 2 : 5);
		}
		for (int i = PieceAmount.PAWN.getAmount() + PieceAmount.ROOK.getAmount() + PieceAmount.HORSE.getAmount()
				+ PieceAmount.BISHOP.getAmount(); i < PieceAmount.PAWN.getAmount() + PieceAmount.ROOK.getAmount()
						+ PieceAmount.HORSE.getAmount() + PieceAmount.BISHOP.getAmount()
						+ PieceAmount.QUEEN.getAmount(); i++) {
			Piece queen = this.pieces.get(i);
			queen.setPosition(isWhitePlayer() ? 0 : 7,isWhitePlayer() ? 3 : 4);
		}
		for (int i = PieceAmount.PAWN.getAmount() + PieceAmount.ROOK.getAmount() + PieceAmount.HORSE.getAmount()
				+ PieceAmount.BISHOP.getAmount() + PieceAmount.QUEEN.getAmount(); i < PieceAmount.PAWN.getAmount()
						+ PieceAmount.ROOK.getAmount() + PieceAmount.HORSE.getAmount() + PieceAmount.BISHOP.getAmount()
						+ PieceAmount.QUEEN.getAmount() + PieceAmount.KING.getAmount(); i++) {
			Piece king = this.pieces.get(i);
			king.setPosition(isWhitePlayer() ? 0 : 7, isWhitePlayer() ? 4 : 3);
		}
	}
}
