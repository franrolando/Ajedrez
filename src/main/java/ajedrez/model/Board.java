package ajedrez.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import ajedrez.exception.MoveException;

public class Board {

	private Cell[][] cells = new Cell[Constants.HEIGHT][Constants.WIDTH];
	private Player whitePlayer;
	private Player blackPlayer;

	public Board(Player whitePlayer, Player blackPlayer) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		initializeBoard();
	}

	private void generateCells() {
		for (int i = 0; i < Constants.HEIGHT; i++) {
			for (int j = 0; j < Constants.WIDTH; j++) {
				Cell cell = new Cell();
				cell.setRow(i);
				cell.setColumn(j);
				this.cells[i][j] = cell;
			}
		}
	}

	private void setPiecesToCellsBiDirec(Player player) {
		player.getPieces().forEach(piece -> {
			Cell cell = this.cells[piece.getRow()][piece.getColumn()];
			piece.setCell(cell);
			cell.setPiece(piece);
		});
	}

	public void drawBoard() {
		for (int i = 0; i < Constants.HEIGHT; i++) {
			for (int j = 0; j < Constants.WIDTH; j++) {
				System.out.print(String.format("%-2s ", this.cells[i][j].getRepresentation()));
			}
			System.out.println();
		}
	}

	public boolean isRunning() {
		// TODO Auto-generated method stub
		return true;
	}

	public void move(String pieceId, int row, String column, PlayerE user) {
		List<Piece> pieces;
		if (user.equals(blackPlayer.getPlayerMood())) {
			pieces = blackPlayer.getPieces();
		} else {
			pieces = whitePlayer.getPieces();
		}
		Optional<Piece> optPiece = pieces.stream().filter(piece -> piece.getId().toUpperCase().equals(pieceId.toUpperCase())).findAny();
		if (optPiece.isPresent()) {
			row = row - 1;
			int columnNumb = Column.findByAbbr(column).getValue();
			Piece piece = optPiece.get();
			if (piece.validMove(row, Column.findByAbbr(column).getValue())) {
				Cell cell = cells[row][columnNumb];
				if (cells[row][columnNumb].isOccupied()) {
					if (user.equals(cell.getPiece().getPlayer().getPlayerMood())) {
						System.out.println("Cell occupied by your piece");
					} else {
						if (!isKingCheck(user)) {
							piece.pieceCaptured();
							movePieceToCell(piece, cell);
						} else {
							System.out.println("Illegal move");
						}
					}
				} else {
					if (!isKingCheck(user)) {
						movePieceToCell(piece, cell);
					} else {
						throw new MoveException("Illegal move");
					}
				}
			} else {
				throw new MoveException("Invalid move");
			}
		} else {
			throw new MoveException("No valid piece");
		}
	}

	private void movePieceToCell(Piece piece, Cell cell) {
		piece.getCell().setPiece(null);
		piece.setCell(cell);
		cell.setPiece(piece);
	}

	private boolean isKingCheck(PlayerE user) {
		// TODO Auto-generated method stub
		return false;
	}

	public BestMove getBestMove() {
		// TODO Auto-generated method stub
		return null;
	}

	private void initializeBoard() {
		generateCells();
		whitePlayer.setPieces(generatePieces());
		blackPlayer.setPieces(generatePieces());
		setPiecesToCellsBiDirec(whitePlayer);
		setPiecesToCellsBiDirec(blackPlayer);
		drawBoard();
	}

	private List<Piece> generatePieces() {
		List<Piece> pieces = new ArrayList<>();
		addPawns(pieces);
		addRook(pieces);
		addKnights(pieces);
		addBishops(pieces);
		addQueen(pieces);
		addKing(pieces);
		return pieces;
	}

	private void addPiece(List<Piece> playerPiecesList, Supplier<Piece> pieceConstructor, int times) {
		for (int i = 0; i < times; i++) {
			Piece newPiece = pieceConstructor.get();
			newPiece.setId(newPiece.getRepresentation() + i);
			playerPiecesList.add(newPiece);
		}
	}

	private void addPawns(List<Piece> playerPiecesList) {
		addPiece(playerPiecesList, Pawn::new, PieceAmount.PAWN.getAmount());
	}

	private void addRook(List<Piece> playerPiecesList) {
		addPiece(playerPiecesList, Rook::new, PieceAmount.ROOK.getAmount());
	}

	private void addBishops(List<Piece> playerPiecesList) {
		addPiece(playerPiecesList, Bishop::new, PieceAmount.BISHOP.getAmount());
	}

	private void addKnights(List<Piece> playerPiecesList) {
		addPiece(playerPiecesList, Knight::new, PieceAmount.HORSE.getAmount());
	}

	private void addQueen(List<Piece> playerPiecesList) {
		addPiece(playerPiecesList, Queen::new, PieceAmount.QUEEN.getAmount());
	}

	private void addKing(List<Piece> playerPiecesList) {
		addPiece(playerPiecesList, King::new, PieceAmount.KING.getAmount());
	}

}
