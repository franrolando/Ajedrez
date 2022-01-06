package ajedrez.model;

public enum PieceAmount {

	KING(1), QUEEN(1), ROOK(2), HORSE(2), BISHOP(2), PAWN(8);

	private Integer amount;

	private PieceAmount(Integer value) {
		this.amount = value;
	}

	public Integer getAmount() {
		return this.amount;
	}
}
