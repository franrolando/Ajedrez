package ajedrez.model;

public class Pawn extends Piece {

	@Override
	public PieceValue getValue() {
		return PieceValue.PAWN;
	}

	@Override
	public String getRepresentation() {
		return "P";
	}

	@Override
	public boolean validMove(Integer row, Integer column) {
		return this.isWhitePlayer() ? (this.getColumn() == column && row - this.getRow() == 1) : (this.getColumn() == column && row - this.getRow() == -1);
	}

}
