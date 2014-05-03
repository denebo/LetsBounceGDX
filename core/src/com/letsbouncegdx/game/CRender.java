package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CRender extends Component {
	private SpriteBatch batch;
	private Texture texture;
	public int x;
	public int y;

	public CRender(Entity container, SpriteBatch batch, String imageUri) {
		super(container);
		this.batch = batch;
		this.texture = new Texture(imageUri);
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void update() {
		batch.draw(texture, x, Gdx.graphics.getHeight() - y);
	}
	
	public int getWidth() { return texture.getWidth(); }
	public int getHeight() { return texture.getHeight(); }
}
