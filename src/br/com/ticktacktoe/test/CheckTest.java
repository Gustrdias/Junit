package br.com.ticktacktoe.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ticktacktoe.controller.ActionsController;
import br.com.ticktacktoe.controller.BoardController;
import br.com.ticktacktoe.controller.CheckController;
import br.com.ticktacktoe.controller.KeyboardController;


public class CheckTest {
	BoardController boardControl =new BoardController();
	ActionsController actionsControl=new ActionsController();
	KeyboardController keyboardControl=new KeyboardController();
	CheckController checkControl=new CheckController();
	
	@Before
	public void setUp() {
		boardControl.initPlays();
		boardControl.createMold();
	}
	@Test
	public void rowOneIsWinTest() {
		boardControl.changeValueMold(1,1, "X");
		boardControl.changeValueMold(1,2, "X");
		boardControl.changeValueMold(1,3, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
		
	}
	@Test
	public void rowTwoIsWinTest() {
		boardControl.changeValueMold(2,1, "X");
		boardControl.changeValueMold(2,2, "X");
		boardControl.changeValueMold(2,3, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
		
	}
	@Test
	public void rowThreeIsWinTest() {
		boardControl.changeValueMold(3,1, "X");
		boardControl.changeValueMold(3,2, "X");
		boardControl.changeValueMold(3,3, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
	}
	@Test
	public void columnOneIsWinTest() {
		boardControl.changeValueMold(1,1, "X");
		boardControl.changeValueMold(2,1, "X");
		boardControl.changeValueMold(3,1, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
		
	}
	@Test
	public void columnTwoIsWinTest() {
		boardControl.changeValueMold(1,2, "X");
		boardControl.changeValueMold(2,2, "X");
		boardControl.changeValueMold(3,2, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
		
	}
	@Test
	public void columnThreeIsWinTest() {
		boardControl.changeValueMold(1,3, "X");
		boardControl.changeValueMold(2,3, "X");
		boardControl.changeValueMold(3,3, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
		
	}
	@Test
	public void rightDiagonalWinTest(){
		boardControl.changeValueMold(1,1, "X");
		boardControl.changeValueMold(2,2, "X");
		boardControl.changeValueMold(3,3, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
	}
	@Test
	public void leftDiagonalWinTest(){
		boardControl.changeValueMold(1,3, "X");
		boardControl.changeValueMold(2,2, "X");
		boardControl.changeValueMold(3,1, "X");
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertTrue(checkControl.winPlayer());
	}
	@Test
	public void isNotWinnerTest() {
		checkControl.isWinnerGame(boardControl.getBoard(), actionsControl.getActions());
		assertFalse(checkControl.getCheck().isWinner());
	}
	
	@Test
	public void isTiedTest() {
		boardControl.changeValueMold(1,1, "X");
		boardControl.changeValueMold(1,2, "X");
		boardControl.changeValueMold(1,3, "O");
		boardControl.changeValueMold(2,1, "O");
		boardControl.changeValueMold(2,2, "X");
		boardControl.changeValueMold(2,3, "X");
		boardControl.changeValueMold(3,1, "X");
		boardControl.changeValueMold(3,2, "O");
		boardControl.changeValueMold(3,3, "O");
		checkControl.isTied(boardControl.getBoard(),actionsControl.getActions());
		assertTrue(actionsControl.getActions().isEndGame());
	}
	@Test
	public void isNotTiedTest() {
		checkControl.isTied(boardControl.getBoard(),actionsControl.getActions());
		assertFalse(actionsControl.getActions().isEndGame());
	}
}
