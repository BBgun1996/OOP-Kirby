package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private KirbyGame kirbyGame;
	private SpriteBatch batch;
	private World world;
	private Cupcake cupcake;
	private Heart heart;
	
	private BitmapFont font;
	private Texture kirbyImg;
	private Texture bgImg;
	private Texture cupcakeImg;
	private Texture heartImg;

	public WorldRenderer(KirbyGame kirbyGame, World world) {
		batch = kirbyGame.batch;
		this.kirbyGame = kirbyGame;
		this.world = world;
		this.cupcake = world.getCupcake();
		this.heart = world.getHeart();
		
		bgImg = new Texture("bg.png");
		kirbyImg = new Texture("kirby.gif");
		cupcakeImg = new Texture("cupcake.gif");
		heartImg = new Texture("heart.png");
		
		font = new BitmapFont();
	}

	public void render(float delta) {
		SpriteBatch batch = kirbyGame.batch;		
		Vector2 pos = world.getKirby().getPosition();
		
		batch.begin();
		batch.draw(bgImg, 0, 0);
		batch.draw(kirbyImg, pos.x-world.getKirby().KIRBY_SIZE, pos.y);
		
		renderCupcake(delta);
		renderHeart(delta);
		
		font.draw(batch, "Level : " + world.getLevel(), (float) (KirbyGame.WIDTH*0.05), KirbyGame.HEIGHT/10);
		font.draw(batch, "Life : " + world.getLife(), (float) (KirbyGame.WIDTH*0.85), KirbyGame.HEIGHT/10);
		font.draw(batch, "Score : " + world.getScore(), (float) (KirbyGame.WIDTH*0.85), KirbyGame.HEIGHT/10-20);
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
	
	private void renderHeart(float delta) {
		for(int y = 0; y < kirbyGame.HEIGHT; y++) {
            for(int x = 0; x < kirbyGame.WIDTH; x++) {
                if(heart.hasHeartAt(x, y)) {
                    batch.draw(heartImg, x, y);
                } 
            }
        }
	}
	
}
