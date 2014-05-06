package com.letsbouncegdx.game;

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
			if(input.getTouchX() > crender.getX()
					&& input.getTouchX() < crender.getX() + crender.getWidth() / 2
					&& input.getTouchY() > crender.getY()
					&& input.getTouchY() < crender.getY() + crender.getHeight() / 2) {
				touching = true;
			}
		}
	}
	
	public boolean isTouching() {
		return touching;
	}
}
