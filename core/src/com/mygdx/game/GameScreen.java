package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
	private World world;
	private WorldRenderer worldRenderer;
	
	public GameScreen(KirbyGame kirbyGame){
		world = new World(kirbyGame);
		worldRenderer = new WorldRenderer(kirbyGame, world);
	}
	
	@Override
    public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render(delta);
    }

	private void update(float delta) {
		updateKirbyDirection();
		world.update(delta);
	}

	private void updateKirbyDirection() {
		Kirby kirby = world.getKirby();
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	kirby.setNextDirection(Kirby.DIRECTION_RIGHT);
        } else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	kirby.setNextDirection(Kirby.DIRECTION_LEFT);
        } else {
        	kirby.setNextDirection(Kirby.DIRECTION_STILL);
        }
		
	}

}
