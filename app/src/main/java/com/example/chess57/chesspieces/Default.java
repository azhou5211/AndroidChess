package com.example.chess57.chesspieces;

import java.util.ArrayList;

/**
 * 
 * The Default piece is a piece where the chess board is actually empty.
 * Instead of having null in the empty chess board spots, we have default
 * that will return false and null for any moves or move lists, respectively.
 * 
 * @author Andrew Zhou
 * @author Bang An
 * @version javaSE-1.8
 */

public class Default extends Piece {
	
	/**
	 * Creates a default piece. default piece is actually where the chess board is empty.
	 * @param player of which this piece belongs to 
	 * @param startIndex is the index where the piece initially belongs
	 * 
	 */
	public Default(String player, int startIndex) {
		super(player,startIndex);
	}


	@Override
	public ArrayList<Integer> getMoveList(int startIndex, String player, Node[] board) {
		return null;
	}
	

	@Override
	public boolean move(String end, String player, Node[] board, ArrayList<String> moveHistory) {
		return false;
	}

	public Piece duplicate() {
		Piece p = new Default(this.player,this.startIndex);
		p.firstMove = this.firstMove;
		return p;
	}

	/**
	 * @return the string format for which the default piece is printed
	 */
	public String toString() {
		return "default (empty)";
	}
}