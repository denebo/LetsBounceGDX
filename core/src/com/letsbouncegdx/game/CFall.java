package com.letsbouncegdx.game;

public class CFall extends Component {
	CRender crender;
	float gravity, accelY;
	
	public CFall(Entity entity, CRender crender, float gravity) {
		super(entity);
		this.crender = crender;
		this.gravity = gravity;
	}
	
	@Override void update() {	
		accelY += gravity;
		crender.setY(crender.getY() + accelY);
	}
}
