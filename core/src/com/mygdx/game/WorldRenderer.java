package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private KirbyGame kirbyGame;
	private SpriteBatch batch;
	private World world;
	private Texture kirbyImg;
	private Texture bgImg;
	private BitmapFont font;
	private CupcakeRenderer cupcakeRenderer;

	public WorldRenderer(KirbyGame kirbyGame, World world) {
		batch = kirbyGame.batch;
		this.kirbyGame = kirbyGame;
		this.world = world;
		cupcakeRenderer = new CupcakeRenderer(world.getCupcake(), kirbyGame.batch);
		kirbyImg = new Texture("kirby.gif");
		bgImg = new Texture("bg.png");
		font = new BitmapFont();
		
	}

	public void render(float delta) {
		SpriteBatch batch = kirbyGame.batch;		
		batch.begin();
		Vector2 pos = world.getKirby().getPosition();
		batch.draw(bgImg, 0, 0);
		batch.draw(kirbyImg, pos.x-world.getKirby().KIRBY_SIZE, pos.y);
		
		
		font.draw(batch, "Level : " + world.getLevel(), (float) (KirbyGame.WIDTH*0.05), KirbyGame.HEIGHT/10);
		font.draw(batch, "Life : " + world.getLife(), (float) (KirbyGame.WIDTH*0.85), KirbyGame.HEIGHT/10);
		font.draw(batch, "Score : " + world.getScore(), (float) (KirbyGame.WIDTH*0.85), KirbyGame.HEIGHT/10-20);
		batch.end();
		
		cupcakeRenderer.render(delta);
	}
	
}
