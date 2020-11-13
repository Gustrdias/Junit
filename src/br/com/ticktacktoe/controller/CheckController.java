package br.com.ticktacktoe.controller;

import br.com.ticktacktoe.model.Actions;
import br.com.ticktacktoe.model.Board;
import br.com.ticktacktoe.model.Check;

public class CheckController {
	private Check check=new Check();
	
	public void isWinnerGame(Board board,Actions actions) {
		this.rowIsWin(board,actions.getMarked());
		this.columnIsWin(board,actions.getMarked());
		this.leftDiagonalWin(board, actions.getMarked());
		this.rightDiagonalWin(board, actions.getMarked());
		if(this.check.isWinner()) {
			System.out.println("O jogador "+actions.getPlayer()+" ganhou!");
			actions.setEndGame(true);
		}
	}
	public void rowIsWin(Board board,String marked) {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
			this.check.resetCount();
			this.walksColumn(board,marked,row);
			if(this.winPlayer())
				return;
		}
	}
	public void walksColumn(Board board,String marked,int row) {
		for (int column = 0; column < Board.MAX_POSITIONS; column++) {
		     if (board.getOnePlay(row, column) == marked) {
		    	 this.check.incrementCount();
		     }
		 }
	}
	public void columnIsWin(Board board,String marked) {
		if(this.check.isWinner())
			return;
        for (int column = 0; column < Board.MAX_POSITIONS; column++) {
        	this.check.resetCount();
        	this.walksRow(board,marked,column);
			if(winPlayer())
				return;
		}
	}
	public void walksRow(Board board,String marked,int column) {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
		     if (board.getOnePlay(row, column) == marked) {
		    	 this.check.incrementCount();
		     }
		 }
	}
	
	public boolean winPlayer() {
		if (this.check.getCount() == Board.MAX_POSITIONS) {
			this.check.setWinner(true);
			return true;
		}
		return false;
	}
	public void rightDiagonalWin(Board board,String marked) {
		if(this.check.isWinner())
			return;
		this.check.resetCount();
		for(int diagonal=0;diagonal < Board.MAX_POSITIONS;diagonal++) {
			if (board.getOnePlay(diagonal,diagonal) == marked) {
				this.check.incrementCount();
			}
		}
		this.winPlayer();
	}
	public void leftDiagonalWin(Board board,String marked) {
		if(this.check.isWinner())
			return;
		this.check.resetCount();
		int posDiagonalColumn = Board.MAX_POSITIONS-1;
		for(int posDiagonalRow = 0; posDiagonalRow < Board.MAX_POSITIONS; posDiagonalRow++) {
			if(board.getOnePlay(posDiagonalRow,posDiagonalColumn) == marked){
				this.check.incrementCount();
			}
			posDiagonalColumn--; 
		}
		this.winPlayer();
	}
	
	public void isTied(Board board,Actions actions) {
		this.check.resetCount();
		playsRow(board);
		if(this.check.getCount() == allPositions()) {
			System.out.println("O jogo terminou empatado!");
			actions.setEndGame(true);
		}
	}
	public int allPositions() {
		return Board.MAX_POSITIONS * Board.MAX_POSITIONS;
	}
	public void playsRow(Board board) {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
			this.playsColumns(board, row);
		 }
	}
	public void playsColumns(Board board,int row) {
		for (int column = 0; column < Board.MAX_POSITIONS; column++) {
			this.markedCount(board,row,column);
		}
	}
	public void markedCount(Board board,int row,int column) {
		if (board.getOnePlay(row,column) != Board.EMPTY_POSITIONS) 
			this.check.incrementCount();
	}
	public Check getCheck() {
		return this.check;
	}
	
	
}
