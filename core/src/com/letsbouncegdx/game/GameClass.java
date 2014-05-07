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
		activeScene = new Scene(this);
		Entity e = new Entity(activeScene);
		CRender crender = new CRender(e, batch, "data/ball_blue.png");
		CTouch ctouch = new CTouch(e, crender);
		CFall cfall = new CFall(e, crender, 5.0f);
		CFallTouch cfalltouch = new CFallTouch(e, cfall, ctouch);
		e.addComponent(crender);
		e.addComponent(ctouch);
		e.addComponent(cfall);
		e.addComponent(cfalltouch);
		activeScene.entities.add(e);	
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
