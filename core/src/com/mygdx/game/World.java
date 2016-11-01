package com.mygdx.game;

public class World {

	private KirbyGame kirbyGame;
	private Kirby kirby;
	
	private int score;

	public World(KirbyGame kirbyGame) {
		kirby = new Kirby(400, 100, this);
		this.kirbyGame = kirbyGame;
		score = 0;
	}

	public void update(float delta) {
		kirby.update();
		
	}

	public Kirby getKirby() {
		return kirby;
	}

	public int getScore() {
		return score;
	}

}
