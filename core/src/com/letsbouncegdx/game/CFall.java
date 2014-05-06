package com.letsbouncegdx.game;

public class CFall extends Component {
	CRender crender;
	int gravity, accelY;
	
	public CFall(Entity entity, CRender crender, int gravity) {
		super(entity);
		this.crender = crender;
		this.gravity = gravity;
	}
	
	@Override void update() {
		if(entity.scene.game.input.isTouched())
			accelY = 0;
			
		accelY += gravity;
		crender.setY(crender.getY() + accelY);
	}
}
