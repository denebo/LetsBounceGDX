package com.letsbouncegdx.game;

public class CFall extends Component {
	CRender crender;
	float gravity, 
		  accelY, 
		  accelX, 
		  accelXCap, 
		  accelYCap;
	
	public CFall(Entity entity, CRender crender, float gravity, float accelXCap, float accelYCap) {
		super(entity);
		this.crender = crender;
		this.gravity = gravity;
		this.accelXCap = accelXCap;
		this.accelYCap = accelYCap;
	}
	
	@Override void update() {	
		accelY += gravity;
		
		if(accelX > accelXCap)
			accelX = accelXCap;
		
		if(accelY > accelYCap)
			accelY = accelYCap;

		crender.y += accelY;
		crender.x += accelX;
	}
}
