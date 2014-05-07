package com.letsbouncegdx.game;

public class CFallTouch extends Component {
	CTouch ctouch;
	CFall cfall;
	CRender crender;
	
	boolean touched;
	boolean animating;
	
	public CFallTouch(Entity entity, CFall cfall, CTouch ctouch) {
		super(entity);
		this.ctouch = ctouch;
		this.cfall = cfall;
		this.crender = cfall.crender;
		this.touched = false;
		this.animating = false;
	}
	
	@Override
	public void update() {
		if(ctouch.isTouching() && !touched) {
			cfall.accelY = -Math.abs(cfall.accelY);
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
