package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;

public class CTouch extends Component {
	private CRender crender;
	private boolean touching;
	
	InputHandler input;

	public CTouch(Entity entity, CRender crender) {
		super(entity);
		this.crender = crender;
		this.touching = false;
		this.input = entity.scene.game.input;
	}

	@Override
	public void update() {
        touching = false;

		if(input.isTouched()){
			if(input.getTouchX() > crender.x
					&& input.getTouchX() < crender.x + crender.getWidth()
					&& input.getTouchY() > crender.y
					&& input.getTouchY() < crender.y + crender.getHeight()) {
				touching = true;
			}	
		}
	}
	
	public int getX() { return input.getTouchX(); }
	public int getY() { return input.getTouchY(); }
	
	public boolean isTouching() {
		return touching;
	}
}
