package br.com.ticktacktoe.model;

import java.util.Arrays;

public class Board {
	public static int MAX_POSITIONS = 3;
	public static String EMPTY_POSITIONS = " ";
	private String plays[][]= new String[MAX_POSITIONS][MAX_POSITIONS];
	private String mold;
	

	public String[][] getPlays() {
		return this.plays;
	}
	public String getOnePlay(int row,int column) {
		return this.plays[row][column];
	}
	public void setOnePlay(int row,int column,String value) {
		this.plays[row][column]=value;
	}
	public void setPlays(String[][] plays) {
		this.plays = plays;
	}
	public String getMold() {
		return this.mold;
	}
	public void setMold(String mold) {
		this.mold = mold;
	}

}
