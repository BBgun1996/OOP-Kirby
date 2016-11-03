package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static final int BLOCK_SIZE = 13;
	
	private KirbyGame kirbyGame;
	private SpriteBatch batch;
	private World world;
	private Texture kirbyImg;
	private BitmapFont font;
	private CupcakeRenderer cupcakeRenderer;

	public WorldRenderer(KirbyGame kirbyGame, World world) {
		batch = kirbyGame.batch;
		this.kirbyGame = kirbyGame;
		this.world = world;
		cupcakeRenderer = new CupcakeRenderer(world.getCupcake(), kirbyGame.batch);
		kirbyImg = new Texture("kirby.gif");
		font = new BitmapFont();
	}

	public void render(float delta) {
		cupcakeRenderer.render(delta);
		
		SpriteBatch batch = kirbyGame.batch;		
		batch.begin();
		Vector2 pos = world.getKirby().getPosition();
		batch.draw(kirbyImg, pos.x-BLOCK_SIZE, pos.y);

		font.draw(batch, "" + world.getScore(), 700, 60);
		batch.end();
	}
	
}
