package com.example.chess57.saveobject;

import android.graphics.drawable.Drawable;

import com.example.chess57.chesspieces.Piece;

import java.io.Serializable;

public class saveObject2 implements Serializable {

	public String str_initial_location;
	public String str_final_location;
	public int initial_location;
	public int final_location;
	public Piece initial_piece;
	public Piece final_piece;

	public saveObject2() {
		str_initial_location = "";
		str_final_location = "";
		initial_location = -1;
		final_location = -1;
		initial_piece = null;
		final_piece = null;
	}

	public saveObject2(String str_initial_location, String str_final_location, int initial_location, int final_location) {
		this.str_initial_location = str_initial_location;
		this.str_final_location = str_final_location;
		this.initial_location = initial_location;
		this.final_location = final_location;
		initial_piece = null;
		final_piece = null;
		this.initial_piece = null;
		this.final_piece = null;

	}

	public saveObject2(String str_initial_location, String str_final_location, int initial_location, int final_location, Piece initial_piece, Piece final_piece) {
		this.str_initial_location = str_initial_location;
		this.str_final_location = str_final_location;
		this.initial_location = initial_location;
		this.final_location = final_location;
		this.initial_piece = initial_piece;
		this.final_piece = final_piece;
	}

}