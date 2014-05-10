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
		CRender crender = new CRender(e, batch, "data/ball_blue.png", 150, 0, 1.0f);
		CTouch ctouch = new CTouch(e, crender);
		CFall cfall = new CFall(e, crender, 0.2f);
		CTouchBounce cfalltouch = new CTouchBounce(e, cfall, ctouch, 15.0f, 20.0f);
		CConstraints cconstraints = new CConstraints(e, cfall, 0, Gdx.graphics.getWidth(), 0, 0);
		e.addComponent(crender);
		e.addComponent(ctouch);
		e.addComponent(cfall);
		e.addComponent(cfalltouch);
		e.addComponent(cconstraints);
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
