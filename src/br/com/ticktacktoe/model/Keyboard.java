package br.com.ticktacktoe.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard {
	private Scanner scanner= new Scanner(System.in);;
	private int row;
	private int column;
	private String key;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public Scanner getScanner() {
		return scanner;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void rowReceiveKey() {
		this.row=Integer.parseInt(this.key);
	}
	public void columnReceiveKey() {
		this.column=Integer.parseInt(this.key);
	}
	
}
