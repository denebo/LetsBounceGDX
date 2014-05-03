package com.letsbouncegdx.game;

public class CTouch extends Component {
	CRender crender;

	public CTouch(Entity entity, CRender crender) {
		super(entity);
		this.crender = crender;
	}

	@Override
	public void update() {
		if(entity.scene.game.input.isTouched()) {
			crender.x = entity.scene.game.input.getTouchX() - crender.getWidth() / 2;
            crender.y = entity.scene.game.input.getTouchY();
		}
	}
}
