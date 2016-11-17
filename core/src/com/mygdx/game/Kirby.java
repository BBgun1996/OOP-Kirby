package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Kirby {
	public static final int KIRBY_SIZE = 13;
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
		
		for(int r = (int)position.y; r < (int)position.y + (KIRBY_SIZE * 2); r++) {
			updateCupcake(r);
			updateHeart(r);
		}
    }
	
	private boolean canMoveInDirection(int dir) {
        int newX = (int)position.x + (SPEED * DIR_OFFSETS[dir]);
 
        if(newX >= KIRBY_SIZE && newX <= kirbyGame.WIDTH-KIRBY_SIZE) {
        	return true;
        }
        
        return false;
    }
	
	private void updateCupcake(int r) {
		for(int c = (int)position.x - world.getCupcake().getSize(); c < (int)position.x + KIRBY_SIZE; c++) {
        	if(c < kirbyGame.WIDTH && c >= 0) {
        		if(world.getCupcake().hasCupcakeAt(c, r)) {
        			world.getCupcake().removeCupcakeAt(c, r);
        			world.increaseScore();
        		}
        	}
        }
	}
	
	private void updateHeart(int r) {
		for(int c = (int)position.x - world.getHeart().getSize(); c < (int)position.x + KIRBY_SIZE; c++) {
        	if(c < kirbyGame.WIDTH && c >= 0) {
        		if(world.getHeart().hasHeartAt(c, r)) {
        			world.getHeart().removeHeartAt(c, r);
        		}
        	}
        }
	}

}
