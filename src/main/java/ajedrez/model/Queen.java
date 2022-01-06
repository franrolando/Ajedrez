package ajedrez.model;

public class Queen extends Piece {
	@Override
	public PieceValue getValue() {
		return PieceValue.QUEEN;
	}

	@Override
	public String getRepresentation() {
		return "Q";
	}

	@Override
	public boolean validMove(Integer row, Integer column) {
		return (this.getRow() == row || this.getColumn() == column) || (Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - column));
	}
}
