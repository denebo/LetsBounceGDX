package com.letsbouncegdx.game;

public class CFallTouch extends Component {
	CTouch ctouch;
	CFall cfall;
	CRender crender;
	
	boolean animating;
	
	public CFallTouch(Entity entity, CFall cfall, CTouch ctouch) {
		super(entity);
		this.ctouch = ctouch;
		this.cfall = cfall;
		this.crender = cfall.crender;
		this.animating = false;
	}
	
	@Override
	public void update() {
//		if(ctouch.isTouching()) {
//			cfall.accelY = -cfall.accelY;
//			crender.alpha = 0.5f;
//		}
//		
//		if(crender.alpha < 1.0f) {
//			crender.alpha += 0.05f;
//		}
	}
}
