package br.com.ticktacktoe.test;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ticktacktoe.controller.BoardController;
import br.com.ticktacktoe.controller.ValidateController;


public class ValidateTest {

	BoardController boardControl =new BoardController();
	
	@Before
	public void setUp() {
		boardControl.initPlays();
		boardControl.createMold();
	}
	@Test
	public void numberRowValidTest() {
		ValidateController validateControl=new ValidateController();
		String value="1";
		validateControl.isValidRow(value);
		assertTrue(validateControl.isPass());
	}
	@Test
	public void incorretNumberRowTest() {
		ValidateController validateControl=new ValidateController();
		String value="5";
		validateControl.isValidRow(value);
		assertFalse(validateControl.isPass());
	}
	@Test
	public void numberColumnValidTest() {
		ValidateController validateControl=new ValidateController();
		String value="1";
		validateControl.isValidColumn(value);
		assertTrue(validateControl.isPass());
	}
	@Test
	public void incorretNumberColumnTest() {
		ValidateController validateControl=new ValidateController();
		String value="5";
		validateControl.isValidColumn(value);
		assertFalse(validateControl.isPass());
	}
	@Test
	public void positionNotMarkedTest() {
		ValidateController validateControl=new ValidateController();
		assertFalse(validateControl.positionCompleted(1,1, boardControl.getBoard()));
	}
	@Test
	public void positionMarkedTest() {
		ValidateController validateControl=new ValidateController();
		boardControl.changeValueMold(1,1, "X");
		assertTrue(validateControl.positionCompleted(1,1, boardControl.getBoard()));
	}
	@Test
	public void typeRowTest() {
		ValidateController validateControl=new ValidateController();
		String value="1";
		validateControl.isValidRow(value);
		assertTrue(validateControl.isPass());
	}
	@Test
	public void notTypeRowTest() {
		ValidateController validateControl=new ValidateController();
		String value="a";
		validateControl.isValidRow(value);
		assertFalse(validateControl.isPass());
	}
	@Test
	public void typeColumnTest() {
		ValidateController validateControl=new ValidateController();
		String value="1";
		validateControl.isValidColumn(value);
		assertTrue(validateControl.isPass());
	}
	@Test
	public void notTypeColumnTest() {
		ValidateController validateControl=new ValidateController();
		String value="a";
		validateControl.isValidColumn(value);
		assertFalse(validateControl.isPass());
	}
	
	
}
