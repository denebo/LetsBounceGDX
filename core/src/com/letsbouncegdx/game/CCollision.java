package com.letsbouncegdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class CCollision extends Component {
	ArrayList<CFall> cfalls;
	Sound collisionSound;
	
	public CCollision(Entity entity, ArrayList<CFall> cfalls) {
		super(entity);
		this.cfalls = cfalls;
		this.collisionSound = Gdx.audio.newSound(Gdx.files.internal("data/collision.mp3"));
	}
	
	@Override
	public void update() {
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
}
