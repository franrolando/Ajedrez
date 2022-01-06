package ajedrez.model;

public enum PieceValue {

	KING(100),QUEEN(8),ROOK(5),KNIGHT(3),BISHOP(3),PAWN(1);
	
	private Integer value;
	
	private PieceValue(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
}
