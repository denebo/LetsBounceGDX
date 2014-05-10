package com.letsbouncegdx.game;

public class CTouchBounce extends Component {
	CTouch ctouch;
	CFall cfall;
	CRender crender;
	
	boolean touched;
	boolean animating;
	float bounce,
		  accelXCap;
	
	public CTouchBounce(Entity entity, CFall cfall, CTouch ctouch, float bounce, float accelXCap) {
		super(entity);
		this.ctouch = ctouch;
		this.cfall = cfall;
		this.accelXCap = accelXCap;
		this.crender = cfall.crender;
		this.touched = false;
		this.animating = false;
		this.bounce = bounce;
	}
	
	@Override
	public void update() {
		if(ctouch.isTouching() && !touched) {
			int x = ctouch.getX();
			int y = ctouch.getY();
			
			// calculate angle between touch and center of object
			float diffX = x - crender.getCenterX();
			float diffY = Math.abs(y - crender.y);
			float angle = (float)Math.atan2(diffY, diffX);
			float forceX = (float)Math.cos(angle) * bounce;
			float forceY = (float)Math.sin(angle) * bounce;
			
			cfall.accelY = 0;
			cfall.accelY -= forceY;
			if(Math.abs(cfall.accelX - forceX) < accelXCap)
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
