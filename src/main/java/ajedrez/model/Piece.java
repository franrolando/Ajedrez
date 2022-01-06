package ajedrez.model;

public abstract class Piece implements Drawable, Movable {

	private String id;
	private Integer row;
	private Integer column;
	private Player player;
	private Boolean alive;
	private Cell cell;

	public abstract PieceValue getValue();

	public void setPosition(Integer row, Integer column) {
		this.row = row;
		this.column = column;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean isWhitePlayer() {
		return player.isWhitePlayer();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public void pieceCaptured() {
		this.alive = false;
	}

	@Override
	public String toString() {
		return id;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
		this.row = cell.getRow();
		this.column = cell.getColumn();
	}

}
