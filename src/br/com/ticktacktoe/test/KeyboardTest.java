package br.com.ticktacktoe.test;

import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import br.com.ticktacktoe.controller.KeyboardController;



public class KeyboardTest {
	KeyboardController keyboardControl=new KeyboardController();
	
	@Test
	public void markedRowOneKeyCorrectTest(){
		keyboardControl.rowChoice(1);
		assertNotEquals(null, keyboardControl.getKeyboard().getRow());
	}
	@Test
	public void markedColumnOneKeyCorrectTest(){
		keyboardControl.columnChoice();
		assertNotEquals(null, keyboardControl.getKeyboard().getColumn());
	}
	
	
}
