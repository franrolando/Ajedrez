package ajedrez.model;

public class Knight extends Piece {
	@Override
	public PieceValue getValue() {
		return PieceValue.KNIGHT;
	}

	@Override
	public String getRepresentation() {
		return "Kn";
	}

	@Override
	public boolean validMove(Integer row, Integer column) {
		return (Math.abs(this.getRow() - row) == 1 && Math.abs(this.getColumn() - column) == 2)
				|| (Math.abs(this.getRow() - row) == 2 && Math.abs(this.getColumn() - column) == 1);
	}
}
