package com.example.chess57.saveobject;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class saveArray implements Serializable, Comparable<saveArray> {

	ArrayList<saveObject2> history;
	Date date;
	String name;

	public saveArray(ArrayList<saveObject2> a, String n) {
		this.history = a;
		this.date = new Date();
		this.name = n;
	}

	public ArrayList<saveObject2> getHistory() {
		return this.history;
	}

	public Date getDate() {
		return this.date;
	}

	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		return this.name + " " + dateFormat.format(this.date);
	}

	public int compareTo(saveArray other) {
		return this.name.compareTo(other.name);
	}
}