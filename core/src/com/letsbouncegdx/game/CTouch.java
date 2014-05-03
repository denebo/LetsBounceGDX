package com.letsbouncegdx.game;

public class CTouch extends Component {
	InputHandler input;
	CRender crender;

	public CTouch(Entity entity, InputHandler input, CRender crender) {
		super(entity);
		this.input = input;
		this.crender = crender;
	}

	@Override
	public void update() {
		if(input.isTouched()) {
			crender.setX(input.getTouchX() - crender.getWidth() / 2);
            crender.setY(input.getTouchY());
		}
	}
}
