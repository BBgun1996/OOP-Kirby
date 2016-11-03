package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CupcakeRenderer {
	private SpriteBatch batch;
	private Texture cupcakeImg;
	private Cupcake cupcake;
	private KirbyGame kirbyGame;
	
	public CupcakeRenderer(Cupcake cupcake, SpriteBatch batch) {
		this.cupcake = cupcake;
		this.batch = batch;
		cupcakeImg = new Texture("cupcake.gif");
	}

	public void render(float delta) {
		batch.begin();
		renderCupcake(delta);
		batch.end();
	}
	
	private void renderCupcake(float delta) {
		for(int y = 0; y < kirbyGame.HEIGHT; y++) {
            for(int x = 0; x < kirbyGame.WIDTH; x++) {
                if(cupcake.hasCupcakeAt(x, y)) {
                    batch.draw(cupcakeImg, x, y);
                } 
            }
        }
	}
}
