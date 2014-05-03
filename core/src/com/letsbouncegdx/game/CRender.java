package com.letsbouncegdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CRender extends Component {
	private SpriteBatch batch;
	private Texture texture;
	public CRender(SpriteBatch batch, Texture texture) {
		this.batch = batch;
		this.texture = texture;
	}
	@Override
	public void update() {
		batch.draw(texture, 0, 0);
	}
}
