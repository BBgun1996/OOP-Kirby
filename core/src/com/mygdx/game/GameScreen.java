package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private KirbyGame kirbyGame;
	private Texture kirbyImg;
	
	public GameScreen(KirbyGame kirbyGame){
		this.kirbyGame = kirbyGame;
		kirbyImg = new Texture("kirby.gif");
	}
	
	@Override
    public void render(float delta) {
        SpriteBatch batch = kirbyGame.batch;
        batch.begin();
        batch.draw(kirbyImg, 100, 100);
        batch.end();
    }

}
