package br.com.ticktacktoe.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.ticktacktoe.controller.BoardController;


public class BoardTest {
	BoardController boardControl =new BoardController();
	int row=1;
	int column=1;
	
	@Before
	public void setUp() {
		boardControl.initPlays();
		boardControl.createMold();
	}
	@Test
	public void positionPlayTest() {
		assertEquals(" ",boardControl.getBoard().getOnePlay(1,1));
	}
	
	@Test
	public void changeValuePositionsTest() {
		
		boardControl.changeValueMold(row,column, "X");
		assertEquals("X",boardControl.getBoard().getOnePlay(0,0));
	}
	@Test
	public void noNullMoldChangeTest(){
		boardControl.getBoard().setMold(null);
		boardControl.PrintMold();
		assertNotNull(boardControl.getBoard().getMold());
	}
	@Test
	public void noNullMoldTest(){
		boardControl.PrintMold();
		assertNotNull(boardControl.getBoard().getMold());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void populatePositionsArrayTest() {
		String matriz[][]= new String[3][3];
		for (String[] populate : matriz) {
		    Arrays.fill(populate,"X");
		}
		boardControl.getBoard().setPlays(matriz);
		assertEquals(boardControl.getBoard().getPlays(),matriz );
	}
}
