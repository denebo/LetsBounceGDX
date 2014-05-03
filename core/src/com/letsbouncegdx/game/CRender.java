package com.letsbouncegdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CRender extends Component {
	private SpriteBatch batch;
	private Texture texture;
	private int x;
	private int y;

	public CRender(SpriteBatch batch, String imageUri) {
		this.batch = batch;
		this.texture = new Texture(imageUri);
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void update() {
		batch.draw(texture, x, y);
	}
	
	public int getWidth() { return texture.getWidth(); }
	public int getHeight() { return texture.getHeight(); }
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
}
