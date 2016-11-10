package com.mygdx.game;

public class Heart extends ObjectsGame {
	private static final int SPEED = 2;
	private static final int HEART_SIZE = 90;
	
	private KirbyGame kirbyGame;
	private World world;
	
	public boolean [][] hasHearts = hasObjects;
	
	public Heart() {
		super();
	}
	
	public void update(int lv) {
    	genObject(lv, HEART_SIZE, 2000);
    	updateObject(SPEED, 0);
	}
	
	public boolean hasHeartAt(int c, int r) {
        return hasHearts[c][r];
    }
    
    public void removeHeartAt(int c, int r) {
        hasHearts[c][r] = false;
    }
    
}
