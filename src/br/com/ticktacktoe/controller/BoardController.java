package br.com.ticktacktoe.controller;

import java.util.Arrays;

import br.com.ticktacktoe.model.Board;
import br.com.ticktacktoe.model.Keyboard;

public class BoardController {
	String mold;
	private Board board=new Board();
	
	public void initPlays() {
		for (String[] play : this.board.getPlays()) {
		    Arrays.fill(play,Board.EMPTY_POSITIONS);
		}
	}
	public void createMold(){ 
		mold="    1   2   3"; 
		mold += "\n---------------\n";
		rowMold();
	}
	public void rowMold() {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
			mold += (row + 1) + " | ";
			columnMold(row);
			mold += "\n---------------\n";
		}
		this.board.setMold(mold);
	}
	public void columnMold(int row) {
		for (int column = 0; column < Board.MAX_POSITIONS; column++) {
			mold +=this.board.getOnePlay(row, column) + " | ";
		}
	}
	public void changeValueMold(int row,int column,String marked) {
		this.board.setOnePlay(row-1,column-1, marked);
	}
	public void PrintMold(){
		if(this.board.getMold() != null) {
			System.out.println(this.board.getMold());
		}else{
			System.out.println("aq");
			createMold();
		}
	}
	public Board getBoard() {
		return this.board;
	}
	
}
