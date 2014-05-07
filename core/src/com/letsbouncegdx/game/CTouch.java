package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;

public class CTouch extends Component {
	private CRender crender;
	private boolean touching;

	public CTouch(Entity entity, CRender crender) {
		super(entity);
		this.crender = crender;
		this.touching = false;
	}

	@Override
	public void update() {
        InputHandler input = entity.scene.game.input;
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
	
	public boolean isTouching() {
		return touching;
	}
}
