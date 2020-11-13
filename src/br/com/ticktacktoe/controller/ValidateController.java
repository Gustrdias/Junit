package br.com.ticktacktoe.controller;

import br.com.ticktacktoe.model.Board;

public class ValidateController {
	private boolean pass=true;
	
	public void isTypeCorrect(String value) {
		try {
			int number=Integer.parseInt(value);
		}catch(NumberFormatException notInteger) {
			System.out.println("Valor digitado inválido");
			setPass(false);
		}
	}
	public void rowValue(int row) {
		if(row-1 >= Board.MAX_POSITIONS) {
			System.out.println("Posição não conhecida");
			setPass(false);
		}
	}
	public void columnValue(int column) {
		
		if(column-1 >=  Board.MAX_POSITIONS) {
			System.out.println("Posição não conhecida");
			setPass(false);
		}
	}
	public boolean positionCompleted(int row,int column,Board board) {
		if(board.getOnePlay(row-1,column-1).equals(" ")) {
			return false;
		}
		return true;
	}
	public boolean isValidRow(String value) {
		setPass(true);
		isTypeCorrect(value);
		if(!isPass())
			return isPass();
		rowValue(Integer.parseInt(value));
		return isPass();
	}
	public boolean isValidColumn(String value) {
		setPass(true);
		isTypeCorrect(value);
		if(!isPass())
			return isPass();
		columnValue(Integer.parseInt(value));
		return isPass();
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
