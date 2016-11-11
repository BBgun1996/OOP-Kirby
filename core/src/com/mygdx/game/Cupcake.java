package com.mygdx.game;

public class Cupcake extends ObjectsGame {
	private static final int SPEED = 2;
	private static final int CUPCAKE_SIZE = 40;
	
	private World world;
	private KirbyGame kirbyGame;
	
	public boolean [][] hasCupcakes = hasObjects;
	
	public Cupcake() {
        super();
    }
    
	public boolean hasCupcakeAt(int c, int r) {
        return hasCupcakes[c][r];
    }
    
    public void removeCupcakeAt(int c, int r) {
        hasCupcakes[c][r] = false;
    }
    
    public void update(int lv) {
    	genObject(lv, CUPCAKE_SIZE, 200);
    	updateObject(SPEED, true);
	}
    
    public int getSize() {
    	return CUPCAKE_SIZE;
    }
}
