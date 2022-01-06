package ajedrez;

import java.util.Scanner;

import ajedrez.exception.MoveException;
import ajedrez.model.BestMove;
import ajedrez.model.BlackPlayer;
import ajedrez.model.Board;
import ajedrez.model.PlayerE;
import ajedrez.model.WhitePlayer;

public class Game {

	private Board board;
	private Scanner scanner = new Scanner(System.in);

	public Game() {
		initializeGame();
		playGame();
	}

	private void initializeGame() {
		System.out.println("Who's white side? 1 - Computer ; 2 - User");
		int choice = scanner.nextInt();

//		if (choice == 1) {
//			BestMove bestMove = board.getBestMove();
//			board.move(bestMove.getPiece(), bestMove.getRow(), bestMove.getColumn(), PlayerE.COMPUTER);
//			board.drawBoard();
//		}
		WhitePlayer whitePlayer = choice == 1 ? new WhitePlayer(PlayerE.COMPUTER) : new WhitePlayer(PlayerE.USER);
		BlackPlayer blackPlayer = choice == 1 ? new BlackPlayer(PlayerE.USER) : new BlackPlayer(PlayerE.COMPUTER);
		this.board = new Board(whitePlayer, blackPlayer);
	}

	private void playGame() {

		while (board.isRunning()) {

			System.out.println("User move: ");
			move(PlayerE.USER);

			if (!board.isRunning()) {
				break;
			}
			move(PlayerE.COMPUTER);
//			BestMove bestMove = board.getBestMove();
//			board.move(bestMove.getPiece(), bestMove.getRow(), bestMove.getColumn(), PlayerE.COMPUTER);
//			board.drawBoard();
		}
	}

	private void move(PlayerE move) {
		String piece = scanner.next();
		int row = scanner.nextInt();
		String column = scanner.next();
		try {
			board.move(piece, row, column, move);
			board.drawBoard();
		} catch (MoveException e) {
			System.out.println(e.getMessage());
			move(move);
		}
	}

}
