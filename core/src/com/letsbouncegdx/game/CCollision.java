package com.letsbouncegdx.game;

import java.util.ArrayList;

public class CCollision extends Component {
	ArrayList<CFall> cfalls;
	public CCollision(Entity entity, ArrayList<CFall> cfalls) {
		super(entity);
		this.cfalls = cfalls;
	}
	
	@Override
	public void update() {

	}
}
