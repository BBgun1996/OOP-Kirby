package com.mygdx.game;

public class World {
	private KirbyGame kirbyGame;
	private Kirby kirby;
	private Cupcake cupcake;
	
	private int level;
	private int score;
	private int life;

	public World(KirbyGame kirbyGame) {
		cupcake = new Cupcake();
		kirby = new Kirby(KirbyGame.WIDTH/2, KirbyGame.HEIGHT/6, this);
		
		level = 1;
		score = 0;
		life = 5;
	}

	public void update(float delta) {
		kirby.update();
		cupcake.update(level);
		increaseLevel();
	}
	
	public Kirby getKirby() {
		return kirby;
	}
	
	public Cupcake getCupcake() {
		return cupcake;
	}

	public int getLevel() {
		return level;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLife() {
		return life;
	}
	
	public void increaseLevel() {
		if(score >= Math.pow(level*4, 2)) {
			level++;
		}
	}

	public void increaseScore() {
		score++;
	}
	
	public void increaseLife() {
		life++;
	}
	
	public void decreaseLife() {
		life--;
	}

}
