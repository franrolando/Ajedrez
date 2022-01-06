package ajedrez.model;

public class Rook extends Piece {
	@Override
	public PieceValue getValue() {
		return PieceValue.ROOK;
	}

	@Override
	public String getRepresentation() {
		return "T";
	}

	@Override
	public boolean validMove(Integer row, Integer column) {
		return this.getRow() == row || this.getColumn() == column;
	}
}
