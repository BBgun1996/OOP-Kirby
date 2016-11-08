package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Cupcake {
	private static final int SPEED = 1;
	private static final int CUPCAKE_SIZE = 40;
	
	private Vector2 position;
	private World world;
	private KirbyGame kirbyGame;
	
	public boolean [][] hasCupcakes;
	
	public Cupcake() {
        initData();
    }
    
    private void initData() {
    	hasCupcakes = new boolean[kirbyGame.WIDTH][kirbyGame.HEIGHT];
        for(int y = 0; y < kirbyGame.HEIGHT; y++) {
            for(int x = 0; x < kirbyGame.WIDTH; x++) {
                    hasCupcakes[x][y] = false;
            }
    	}
    }
	 
	public boolean hasCupcakeAt(int c, int r) {
        return hasCupcakes[c][r];
    }
    
    public void removeCupcakeAt(int c, int r) {
        hasCupcakes[c][r] = false;
    }
    
    public void update(int lv) {
    	genCupcake(lv);
    	for(int y = 0; y < kirbyGame.HEIGHT; y++) {
    		for(int x = 0; x < kirbyGame.WIDTH; x++) {
    			if(y > kirbyGame.HEIGHT/6) {
    				if(hasCupcakeAt(x, y) && y > SPEED) {
    					hasCupcakes[x][y-SPEED] = true;
    				}
    				removeCupcakeAt(x, y);
    			} else {
    				removeCupcakeAt(x, y);
    			}
    		}
        }
	}
    
    private void genCupcake(int lv) {
		int x = randomInt(300/lv);
		if(x < 1) {
			x = randomInt(kirbyGame.WIDTH-CUPCAKE_SIZE);
			hasCupcakes[x][kirbyGame.HEIGHT-1] = true;
		}
	}
    
    private int randomInt(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
	}
    
}
