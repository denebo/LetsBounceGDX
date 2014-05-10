package com.letsbouncegdx.game;

public class CConstraints extends Component {
	CFall cfall;
	CRender crender;
	float x1, 
		  x2, 
		  y1,
		  y2;

	public CConstraints(Entity entity, CFall cfall, float x1, float x2, float y1, float y2) {
		super(entity);
		this.cfall = cfall;
		this.crender = cfall.crender;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public void update() {
		if(crender.x < x1) {
			cfall.accelX = -cfall.accelX;
			crender.x = x1;
		}

		if(crender.x + crender.getWidth() > x2) {
			cfall.accelX = -cfall.accelX;
			crender.x = x2 - crender.getWidth();
		}
	}
}
