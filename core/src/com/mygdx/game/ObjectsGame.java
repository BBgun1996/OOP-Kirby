package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class ObjectsGame {
	private World world;
	private KirbyGame kirbyGame;
	
	public boolean [][] hasObjects;

	public ObjectsGame() {
		initData();
	}
	
	public void initData() {
    	hasObjects = new boolean[kirbyGame.WIDTH][kirbyGame.HEIGHT];
        for(int y = 0; y < kirbyGame.HEIGHT; y++) {
            for(int x = 0; x < kirbyGame.WIDTH; x++) {
                    hasObjects[x][y] = false;
            }
    	}
    }
	 
	private boolean hasObjectAt(int c, int r) {
        return hasObjects[c][r];
    }
    
    private void removeObjectAt(int c, int r) {
        hasObjects[c][r] = false;
    }
    
    protected void genObject(int level, int OBJECT_SIZE, int range) {
		int x = randomInt(range / level);
		if(x < 1) {
			x = randomInt(kirbyGame.WIDTH - OBJECT_SIZE);
			hasObjects[x][kirbyGame.HEIGHT - 1] = true;
		}
	}
    
    protected void updateObject(int SPEED, boolean deleteWhenObjDropAtFloor) {
    	for(int y = 0; y < kirbyGame.HEIGHT; y++) {
    		for(int x = 0; x < kirbyGame.WIDTH; x++) {
    			if(y > kirbyGame.HEIGHT / 6) {
    				if(hasObjectAt(x, y) && y > SPEED) {
    					hasObjects[x][y - SPEED] = true;
    				}
    				removeObjectAt(x, y);
    			} else if (deleteWhenObjDropAtFloor) {
    				removeObjectAt(x, y);
    			}
    		}
        }
    }
    
    private int randomInt(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
	}
}
