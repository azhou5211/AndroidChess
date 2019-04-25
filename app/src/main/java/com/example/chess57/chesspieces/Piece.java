package com.example.chess57.chesspieces;

import java.util.ArrayList;
import com.example.chess57.play_chess;

/**
 * Abstract class. It is a super class for all pieces (Pawn, Rook, Knight, Bishop, Queen, King, and Default)
 * It provides two abstract methods which all pieces need to implement (getMoveList and move).
 * It also provides functionality such as executing a move, converting a string to an index, calculating distance of a move, and getting the enemy player.
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public abstract class Piece {
	/**
	 * The player to which the piece belongs to
	 */
	public String player;
	
	/**
	 * The initial location of that piece
	 */
	public int startIndex;
	
	/**
	 * A boolean that is true if the piece has not moved yet.
	 */
	public boolean firstMove;

	public abstract Piece duplicate();

	public abstract boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory);
	

	public abstract ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board);
	

	public static boolean executeMoveKingChecked(Node[] board, int startIndex, int endIndex, String player) {
		Piece temp = board[startIndex].piece;
		boolean endIndexEmpty = board[endIndex].gridEmpty;
		Piece temp2 = board[endIndex].piece;
		
		board[startIndex].gridEmpty = true;
		board[endIndex].gridEmpty = false;
		board[endIndex].piece = temp;
		temp.startIndex = endIndex;
		board[startIndex].piece = new Default("null",-1);
		
		boolean kingChecked = false;
		
		int kingIndex=-1;
		if (player.equals("w")) {
			kingIndex = play_chess.whiteKing.startIndex;
		} else {
			kingIndex = play_chess.blackKing.startIndex;
		}
		
		if(King.isPositionChecked(board, kingIndex, player)) {
			kingChecked = true;
		}
		
		board[startIndex].gridEmpty = false;
		board[endIndex].gridEmpty = endIndexEmpty;
		board[startIndex].piece = temp;
		temp.startIndex = startIndex;
		board[endIndex].piece = temp2;
		
		return kingChecked;
	}
	

	public static int getIndex(String FileRank) {
		int index;
		char File = FileRank.charAt(0);
		char Rank = FileRank.charAt(1);
		int col = File - 'a';
		int row = 8 - (Rank - '0');
		index = 8*row + col;
		return index;
	}
	

	public static void executeMove(Node[] board, int startIndex, int endIndex, ArrayList<String> moveHistory) {
		board[endIndex].gridEmpty = false;
		board[startIndex].gridEmpty = true;
		board[endIndex].piece = board[startIndex].piece;
		board[endIndex].piece.startIndex = endIndex;
		board[startIndex].piece = new Default("null",-1);
		String history = Integer.toString(startIndex) + " " + Integer.toString(endIndex);
		moveHistory.add(history);
	}
	

	public static int distance(String move) {
		String[] splitted = move.split("\\s+");
		int startIndex = Integer.parseInt(splitted[0]);
		int endIndex = Integer.parseInt(splitted[1]);
		int startRow = (int) Math.floor(startIndex/8);
		int startCol = startIndex%8;
		int endRow = (int) Math.floor(endIndex/8);
		int endCol = endIndex%8;
		int distance = Math.abs((endRow - startRow)) + Math.abs((endCol - startCol));
		return distance;
	}
	

	public static int distance(int startIndex, int endIndex) {
		int startRow = (int) Math.floor(startIndex/8);
		int startCol = startIndex%8;
		int endRow = (int) Math.floor(endIndex/8);
		int endCol = endIndex%8;
		int distance = Math.abs((endRow - startRow)) + Math.abs((endCol - startCol));
		return distance;
	}
	

	public static String convertRowCol(int index) {
		int row = (int) Math.floor(index/8);
		int col = index%8;
		String ans = Integer.toString(row) + " " + Integer.toString(col);
		return ans;
	}
	

	public static void RowColPrintList(ArrayList<Integer> list) {
		for(Integer index: list) {
			int row = (int) Math.floor(index/8);
			int col = index%8;
			System.out.print("[" + row + " " + col + "],");
		}
	}
	

	public static String getEnemyPlayer(String player) {
		if(player.equals("w")) {
			return "b";
		} else {
			return "w";
		}
	}
	

	public Piece(String player, int startIndex) {
		this.player = player;
		this.startIndex = startIndex;
		this.firstMove = true;
	}
}