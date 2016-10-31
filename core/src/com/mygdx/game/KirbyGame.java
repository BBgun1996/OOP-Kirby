package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class KirbyGame extends ApplicationAdapter {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public SpriteBatch batch;
	 
    @Override
    public void create () {
        batch = new SpriteBatch();
    }
 
    @Override
    public void render () {
        super.render();
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
}
