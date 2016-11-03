package com.mygdx.game;

import java.util.Random;

public class World {

	private KirbyGame kirbyGame;
	private Kirby kirby;
	private Cupcake cupcake;
	
	private int score;

	public World(KirbyGame kirbyGame) {
		kirby = new Kirby(400, 100, this);
		this.kirbyGame = kirbyGame;
		
		genCupcake();
		
		score = 0;
	}

	public void update(float delta) {
		kirby.update();
		cupcake.update();
	}
	
	private void genCupcake(){
		Random randomGenerator = new Random();
		int randomX = randomGenerator.nextInt(kirbyGame.WIDTH);
		cupcake = new Cupcake(randomX, kirbyGame.HEIGHT, this);
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
	
}
