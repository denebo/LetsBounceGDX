package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class CTouchBounce extends Component {
	CTouch ctouch;
	CFall cfall;
	CRender crender;
	
	boolean touched;
	boolean animating;
	float bounce,
		  accelXCap;
	Sound touchSound;
	
	public CTouchBounce(Entity entity, CFall cfall, CTouch ctouch, float bounce, String touchSound) {
		super(entity);
		this.ctouch = ctouch;
		this.cfall = cfall;
		this.crender = cfall.crender;
		this.touched = false;
		this.animating = false;
		this.bounce = bounce;
		this.touchSound = Gdx.audio.newSound(Gdx.files.internal(touchSound));
	}
	
	@Override
	public void update() {
		if(ctouch.isTouching() && !touched) {
			touchSound.play();
			int x = ctouch.getX();
			int y = ctouch.getY();
			
			// calculate angle between touch and center of object
			float diffX = x - crender.getCenterX();
			float diffY = Math.abs(y - crender.y);
			float angle = (float)Math.atan2(diffY, diffX);
			float forceX = (float)Math.cos(angle) * bounce;
			float forceY = (float)Math.sin(angle) * bounce;
			
			cfall.accelY = cfall.accelX = 0;
			cfall.accelY -= forceY;
			cfall.accelX -= forceX;
			
			crender.alpha = 0.5f;
			touched = true;
		}
		
		if(!ctouch.isTouching())
			touched = false;
		
		if(crender.alpha < 0.99f) {
			crender.alpha += 0.01f;
		}
	}
}
