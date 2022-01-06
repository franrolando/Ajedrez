package ajedrez.model;

public class Cell implements Drawable {

	private Integer row;
	private Integer column;
	private Piece piece;

	public Cell() {

	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	@Override
	public String getRepresentation() {
		return piece == null ? "-" : piece.getRepresentation();
	}
	
	public Boolean isOccupied() {
		return this.piece != null;
	}

}
