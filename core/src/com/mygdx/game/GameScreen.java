package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private World world;
	private WorldRenderer worldRenderer;
	private KirbyGame kirbyGame;
	
	public static final int SCREEN_MENU = 0;
	public static final int SCREEN_GAME = 1;
	public static final int SCREEN_PAUSE = 2;
	public static final int SCREEN_GAMEOVER = 3;
	
	private int screen;
	private Texture menuImg;
	private Texture pauseImg;
	private Texture gameoverImg;
	
	
	public GameScreen(KirbyGame kirbyGame) {
		this.kirbyGame = kirbyGame;
		world = new World(kirbyGame);
		worldRenderer = new WorldRenderer(kirbyGame, world);
		
		screen = SCREEN_MENU;
		menuImg = new Texture("menu.png");
		pauseImg = new Texture("pause.png");
		gameoverImg = new Texture("gameover.png");
	}
	
	@Override
    public void render(float delta) {
		SpriteBatch batch = kirbyGame.batch;
		updateScreen();
		
		if(screen == SCREEN_MENU) {
			batch.begin();
			batch.draw(menuImg, 0, 0);
			batch.end();	
		} else if(screen == SCREEN_GAME) {
			update(delta);
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			worldRenderer.render(delta);
		} else if(screen == SCREEN_PAUSE) {
			batch.begin();
			batch.draw(pauseImg, 0, 0);
			batch.end();
		} else if(screen == SCREEN_GAMEOVER) {
			batch.begin();
			batch.draw(gameoverImg, 0, 0);
			batch.end();
		}

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
	
	private void updateScreen() {
		if(screen == SCREEN_MENU) {
			if(Gdx.input.isKeyPressed(Keys.SPACE)) {
				screen = SCREEN_GAME;
			}
		} else if(screen == SCREEN_GAME) {
			if(Gdx.input.isKeyPressed(Keys.P)) {
				screen = SCREEN_PAUSE;
			}
		} else if(screen == SCREEN_PAUSE) {
			if(Gdx.input.isKeyPressed(Keys.SPACE)) {
				screen = SCREEN_GAME;
			}
		} else if(screen == SCREEN_GAMEOVER) {
			if(Gdx.input.isKeyPressed(Keys.ENTER)) {
				this.world = new World(kirbyGame);
				this.worldRenderer = new WorldRenderer(kirbyGame, world);
				screen = SCREEN_MENU;
			}
		}
		
		if(world.getLife() < 1) {
			screen = SCREEN_GAMEOVER;
		}
	}

}
