package com.letsbouncegdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClass extends ApplicationAdapter {
	Scene activeScene;
	SpriteBatch batch;
	InputHandler input;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		input = new InputHandler(Gdx.input);
		activeScene = new Scene();
		Entity e = new Entity();
		CRender crender = new CRender(batch, "data/jet.png");
		Component ctouch = new CTouch(input, crender);
		e.addComponent(crender);
		e.addComponent(ctouch);
		activeScene.entities.add(e);	
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		// testing
		activeScene.update();

		batch.end();
	}
}
