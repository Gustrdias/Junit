package br.com.ticktacktoe.controller;


import br.com.ticktacktoe.model.Keyboard;


public class KeyboardController {
	Keyboard keyboard=new Keyboard();
	ValidateController validate=new ValidateController();
	
	public void rowChoice(int currentPlayer) {
		System.out.println("Jogador " + currentPlayer + " digite a posição (linha): ");
		keyboard.setKey(keyboard.getScanner().next());
		
	}
	public void columnChoice() {
		System.out.println("Agora digite a posição (coluna): ");
		keyboard.setKey(keyboard.getScanner().next());
		
	}
	public Keyboard getKeyboard() {
		return keyboard;
	}
	
}
