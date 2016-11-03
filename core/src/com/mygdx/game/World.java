package com.mygdx.game;

public class World {
	private KirbyGame kirbyGame;
	private Kirby kirby;
	private Cupcake cupcake;
	
	private int score;

	public World(KirbyGame kirbyGame) {
		cupcake = new Cupcake();
		kirby = new Kirby(400, 100, this);
		this.kirbyGame = kirbyGame;

		score = 0;
	}

	public void update(float delta) {
		kirby.update();
		cupcake.update();
	}
	
	public Kirby getKirby() {
		return kirby;
	}
	
	public Cupcake getCupcake() {
		return cupcake;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore() {
		score++;
	}

}
