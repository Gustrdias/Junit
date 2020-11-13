package br.com.ticktacktoe.model;


public class Check {
	private int count;
	private boolean winner;
	
	public Check() {
		this.setCount(0);
		this.setWinner(false);
	}
	
	public void incrementCount() {
		this.count++;
	}
	public void resetCount() {
		this.setCount(0);
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isWinner() {
		return this.winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}
