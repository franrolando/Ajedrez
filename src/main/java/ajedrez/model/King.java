package ajedrez.model;

public class King extends Piece {
	@Override
	public PieceValue getValue() {
		return PieceValue.KING;
	}

	@Override
	public String getRepresentation() {
		return "K";
	}

	@Override
	public boolean validMove(Integer row, Integer column) {
		return Math.abs(this.getRow() - row) <= 1 && Math.abs(this.getColumn() - column) <= 1;
	}
}
