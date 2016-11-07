package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Cupcake {
	private static final int SPEED = 1;
	
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
    
    public void update() {
    	genCupcake();
    	for(int y = 0; y < kirbyGame.HEIGHT; y++) {
            for(int x = 0; x < kirbyGame.WIDTH; x++) {
                if(hasCupcakeAt(x, y) && y > SPEED) {
                    hasCupcakes[x][y-SPEED] = true;
                    //System.out.println(x);//
                }
                removeCupcakeAt(x, y);
            }
        }
	}
    
    private void genCupcake() {
		int x = randomInt(kirbyGame.WIDTH * 2);//200
		if(x < kirbyGame.WIDTH) {
			x = randomInt(kirbyGame.WIDTH-1);
			hasCupcakes[x][kirbyGame.HEIGHT-1] = true;
		}
	}
    
    private int randomInt(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
	}
    
}
