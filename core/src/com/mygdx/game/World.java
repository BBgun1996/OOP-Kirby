package com.mygdx.game;

public class World {
	private KirbyGame kirbyGame;
	private Kirby kirby;
	private Cupcake cupcake;
	private Heart heart;
	
	private int level;
	private int score;
	private int life;

	public World(KirbyGame kirbyGame) {
		cupcake = new Cupcake();
		heart = new Heart();
		kirby = new Kirby((KirbyGame.WIDTH / 2), (KirbyGame.HEIGHT / 6), this);
		
		level = 1;
		score = 0;
		life = 2;
	}

	public void update(float delta) {
		kirby.update();
		cupcake.update(level);
		heart.update(level);
		updateHeart();
		increaseLevel();
	}
	
	public Kirby getKirby() {
		return kirby;
	}
	
	public Cupcake getCupcake() {
		return cupcake;
	}
	
	public Heart getHeart() {
		return heart;
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
		if(score >= Math.pow((level + 1), 2)) {
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

	private void updateHeart() {
		for(int x = 0; x < kirbyGame.WIDTH; x++) {
    		if(getHeart().hasHeartAt(x, (kirbyGame.HEIGHT / 6) + 2)) {
    			getHeart().removeHeartAt(x, (kirbyGame.HEIGHT / 6) + 2);
    			decreaseLife();
    		}
    	}
	}

}
