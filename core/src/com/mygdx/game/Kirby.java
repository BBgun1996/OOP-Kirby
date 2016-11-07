package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Kirby {
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_LEFT = 2;
	public static final int DIRECTION_STILL = 0;
	private static final int SPEED = 5;
	private static final int[] DIR_OFFSETS = {0, 1, -1};
	
	private Vector2 position;
	private int currentDirection;
	private int nextDirection;
	private World world;
	private WorldRenderer worldRenderer;
	private KirbyGame kirbyGame;
	private Cupcake cupcake;
	 
	public Kirby(int x, int y, World world) {
		position = new Vector2(x,y);
		currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
		this.world = world;
	}    
	 
	public Vector2 getPosition() {
		return position;    
	}

	public void setNextDirection(int dir) {
		nextDirection = dir;
		
	}
	
	public void update() {
		if(canMoveInDirection(nextDirection)) {
			currentDirection = nextDirection;  
		} else {
			currentDirection = DIRECTION_STILL;
		}
		position.x += SPEED * DIR_OFFSETS[currentDirection];
		
		System.out.println(position.x);
		for(int r = (int)position.y-26; r < (int)position.y+26; r++) {
            for(int c = (int)position.x-26-26; c < (int)position.x+13; c++) {
            	if(c < kirbyGame.WIDTH && c >= 0) {
            		if(world.getCupcake().hasCupcakeAt(c, r)) {
            			System.out.println("++++++");
            			world.getCupcake().removeCupcakeAt(c, r);
            			world.increaseScore();
            		}
            	}
            }
		}
    }
	
	private boolean canMoveInDirection(int dir) {
        int newX = (int) (position.x + (SPEED * DIR_OFFSETS[dir]));
 
        if(newX >= WorldRenderer.BLOCK_SIZE && newX <= kirbyGame.WIDTH-WorldRenderer.BLOCK_SIZE) {
        	return true;
        }
        
        return false;
    }


}
