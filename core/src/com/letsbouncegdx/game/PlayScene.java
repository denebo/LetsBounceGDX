package com.letsbouncegdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;

public class PlayScene extends Scene {
	Sound collisionSound;
	ArrayList<CFall> cfalls = new ArrayList<CFall>();

	public PlayScene(GameClass game) {
		super(game);
		this.collisionSound = Gdx.audio.newSound(Gdx.files.internal("data/collision.mp3"));
		
		addBall(0, 0, 0.2f);
		addBall(256, 0, 1.0f);
		addBall(512, 0, 0.02f);
	}
	
	@Override
	public void update() {
		super.update();
		
		for(int i = 0; i < cfalls.size(); i++) {
			CFall cfallA = cfalls.get(i);
			for(int j = i + 1; j < cfalls.size(); j++) {
				CFall cfallB = cfalls.get(j);		

				// check if both objects are touching
				// using circular collision detection
				float diffX = cfallA.crender.getCenterX() - cfallB.crender.getCenterX();
				float diffY = cfallA.crender.getCenterY() - cfallB.crender.getCenterY();
				float distance = (float)Math.sqrt(diffX * diffX + diffY * diffY);
				
				if(distance < cfallA.crender.getWidth() / 2 + cfallB.crender.getWidth() / 2) {
					// they're colliding
               		collisionSound.play();
                        
                    // calculate angle between touch and center of object
                    float angle = (float)Math.atan2(diffY, diffX);
                    float forceX = (float)Math.cos(angle) * Math.abs(cfallA.accelX - cfallB.accelX);
                    float forceY = (float)Math.sin(angle) * Math.abs(cfallA.accelY - cfallB.accelY);
                    cfallA.accelY += forceY;
                    cfallA.accelX += forceX;
                        
                    cfallB.accelY -= forceY;
                    cfallB.accelX -= forceX;
				}
			}
		}
	}

	public void addBall(float x, float y, float gravity) {
		Entity e = new Entity(this);
		CRender crender = new CRender(e, game.batch, "data/ball_blue.png", x, y, 1.0f);
		CTouch ctouch = new CTouch(e, crender);
		CFall cfall = new CFall(e, crender, gravity, 20.0f, 25.0f);
		CTouchBounce ctouchbounce = new CTouchBounce(e, cfall, ctouch, 25.0f, "data/touchsound.mp3");
		CConstraints cconstraints = new CConstraints(e, cfall, 0, Gdx.graphics.getWidth(), 0, Gdx.graphics.getHeight());
		CTouchCount ctouchcount = new CTouchCount(e, ctouch, crender, 10, Color.WHITE);
		
		cfalls.add(cfall);

		e.addComponent(crender);
		e.addComponent(ctouch);
		e.addComponent(cfall);
		e.addComponent(ctouchbounce);
		e.addComponent(cconstraints);
		e.addComponent(ctouchcount);
		entities.add(e);	
	}
}
