package br.com.ticktacktoe.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.ticktacktoe.controller.ActionsController;


public class ActionsTest {
	
	ActionsController actionsControl= new ActionsController();
	
	@Before
	public void setUp() {
		this.actionsControl.getBoard().initPlays();
		this.actionsControl.getBoard().createMold();
	}
	@Test
	public void markedXTest() {
		this.actionsControl.nextTurn();
		this.actionsControl.changeMarked();
		assertEquals("X",this.actionsControl.getActions().getMarked());
	}
	@Test
	public void markedOTest() {
		this.actionsControl.nextTurn();
		assertEquals("O",this.actionsControl.getActions().getMarked());
	}
	@Test
	public void isPlayerOneTest() {
		this.actionsControl.nextTurn();
		this.actionsControl.changePlayer();
		assertEquals(1,this.actionsControl.getActions().getPlayer());
	}
	@Test
	public void changePlayerTwoTest() {
		this.actionsControl.nextTurn();
		assertEquals(2,this.actionsControl.getActions().getPlayer());
	}
	@Test
	public void playLoopTest() {
		this.actionsControl.getKeyboardControl().getKeyboard().setRow(1);
		this.actionsControl.getKeyboardControl().getKeyboard().setColumn(1);
		
		this.actionsControl.changePlayerGame();
		assertEquals(2,this.actionsControl.getActions().getPlayer());
	}
	@Test
	public void playLoopWrongTest() {
		this.actionsControl.getKeyboardControl().getKeyboard().setRow(1);
		this.actionsControl.getKeyboardControl().getKeyboard().setColumn(1);
		this.actionsControl.draw();
		this.actionsControl.changePlayerGame();
		assertEquals(1,this.actionsControl.getActions().getPlayer());
	}
	
}
