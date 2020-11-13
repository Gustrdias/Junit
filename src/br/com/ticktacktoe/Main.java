package br.com.ticktacktoe;

import br.com.ticktacktoe.controller.ActionsController;


public class Main {
		
	public static void main(String[] args) {
		ActionsController actionsController=new ActionsController();
		actionsController.loopGame();
		actionsController.getKeyboardControl().getKeyboard().getScanner().close();
		
	}
	
}
