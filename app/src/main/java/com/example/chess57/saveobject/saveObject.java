package com.example.chess57.saveobject;

import android.graphics.drawable.Drawable;
import com.example.chess57.chesspieces.*;

public class saveObject {

	public String str_initial_location;
	public String str_final_location;
	public int initial_location;
	public int final_location;
	public Drawable initial_draw;
	public Drawable final_draw;
	public Piece initial_piece;
	public Piece final_piece;

	public saveObject() {
		str_initial_location = "";
		str_final_location = "";
		initial_location = -1;
		final_location = -1;
		initial_draw = null;
		final_draw = null;
		initial_piece = null;
		final_piece = null;
	}

	public saveObject(String str_initial_location, String str_final_location, int initial_location, int final_location) {
		this.str_initial_location = str_initial_location;
		this.str_final_location = str_final_location;
		this.initial_location = initial_location;
		this.final_location = final_location;
		initial_draw = null;
		final_draw = null;
		initial_piece = null;
		final_piece = null;
		this.initial_piece = null;
		this.final_piece = null;

	}

	public saveObject(String str_initial_location, String str_final_location, int initial_location, int final_location, Drawable initial_draw, Drawable final_draw, Piece initial_piece, Piece final_piece) {
		this.str_initial_location = str_initial_location;
		this.str_final_location = str_final_location;
		this.initial_location = initial_location;
		this.final_location = final_location;
		this.initial_draw = initial_draw;
		this.final_draw = final_draw;
		this.initial_piece = initial_piece;
		this.final_piece = final_piece;
	}

}