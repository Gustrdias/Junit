package br.com.ticktacktoe.model;

public class Actions {
	
	private int player;
	private String marked;
	private boolean endGame;
	
	
	public Actions() {
		this.setPlayer(1);
		this.setMarked("X");
		this.setEndGame(false);
	}
	
	public boolean isEndGame() {
		return this.endGame;
	}
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	public int getPlayer() {
		return this.player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public String getMarked() {
		return this.marked;
	}
	public void setMarked(String marked) {
		this.marked = marked;
	}
	
}
