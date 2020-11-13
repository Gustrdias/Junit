package br.com.ticktacktoe.controller;

import br.com.ticktacktoe.model.Actions;

public class ActionsController {
	private Actions actions=new Actions();
	private BoardController boardControl=new BoardController();
	private KeyboardController keyboardControl=new KeyboardController();
	private ValidateController validate= new ValidateController();
	private CheckController checkControl= new CheckController();
	
	
	public void nextTurn() {
		changePlayer();
		changeMarked();
	}
	public void changePlayer() {
		if(this.actions.getPlayer() == 1)
			this.actions.setPlayer(2);
		else
			this.actions.setPlayer(1);
	}
	public void changeMarked() {
		if(this.actions.getMarked()== "X")
			this.actions.setMarked("O");
		else
			this.actions.setMarked("X");
	}
	
	public void loopGame() {
		
		while (!actions.isEndGame()) {
			keyPressRow();
			keyPressColumn();
			changePlayerGame();
		}
	}
	public void keyPressRow() {
		this.keyboardControl.rowChoice(actions.getPlayer());
		if(!this.validate.isValidRow(this.keyboardControl.getKeyboard().getKey())) {
			this.keyPressRow();
			return;
		}
		this.keyboardControl.getKeyboard().rowReceiveKey();
	}
	public void keyPressColumn() {
		this.keyboardControl.columnChoice();
		if(!this.validate.isValidColumn(this.keyboardControl.getKeyboard().getKey())) {
			this.keyPressColumn();
			return;
		}
		this.keyboardControl.getKeyboard().columnReceiveKey();
	}
	public void draw() {
		this.boardControl.changeValueMold(this.keyboardControl.getKeyboard().getRow(),this.keyboardControl.getKeyboard().getColumn(),actions.getMarked());
		this.boardControl.createMold();
		this.boardControl.PrintMold();
	}
	public void resultGame() {
		this.checkControl.isWinnerGame(this.boardControl.getBoard(),this.actions);
		this.checkControl.isTied(this.boardControl.getBoard(),this.actions);
	}
	public void changePlayerGame() {
		if(!this.validate.positionCompleted(this.keyboardControl.getKeyboard().getRow(),this.keyboardControl.getKeyboard().getColumn(), this.boardControl.getBoard())) {
			this.draw();
			this.resultGame();
			this.nextTurn();
		}else {
			System.out.println("Posição já preenchida");
		}
	}
	
	public BoardController getBoard() {
		return this.boardControl;
	}
	public Actions getActions() {
		return actions;
	}
	
	public KeyboardController getKeyboardControl() {
		return keyboardControl;
	}
	
	
}
