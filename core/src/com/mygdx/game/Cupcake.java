package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Cupcake {
	private static final int SPEED = 1;
	
	private Vector2 position;
	private int currentDirection;
	private int nextDirection;
	private World world;
	private WorldRenderer worldRenderer;
	private KirbyGame kirbyGame;
	 
	public Cupcake(int x, int y, World world) {
		position = new Vector2(x,y);
		this.world = world;
	}    
	 
	public Vector2 getPosition() {
		return position;    
	}
	
	public void update() {
        position.y -= SPEED;
    }
	
}
