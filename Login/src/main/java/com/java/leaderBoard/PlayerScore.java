package com.java.leaderBoard;

public class PlayerScore {
	private String uname;
	private int score;

	public PlayerScore(String uname, int score) {
		this.uname = uname;
		this.score = score;
	}

	public String getUname() {
		return uname;
	}
	
	public int getScore() {
		return score;
	}

}
