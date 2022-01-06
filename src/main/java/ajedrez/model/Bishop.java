package ajedrez.model;

public class Bishop extends Piece {
	@Override
	public PieceValue getValue() {
		return PieceValue.BISHOP;
	}

	@Override
	public String getRepresentation() {
		return "B";
	}

	@Override
	public boolean validMove(Integer row, Integer column) {
		return Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - column);
	}
}
