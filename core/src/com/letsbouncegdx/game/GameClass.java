package com.letsbouncegdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClass extends ApplicationAdapter {
	Scene activeScene;
	SpriteBatch batch;
	InputHandler input;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		input = new InputHandler(Gdx.input);
		
		//testing
		activeScene = new PlayScene(this);
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		activeScene.update();

		batch.end();
	}
}
