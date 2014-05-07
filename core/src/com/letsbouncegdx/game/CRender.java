package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CRender extends Component {
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private float x;
	private float y;
	public float alpha;

	public CRender(Entity container, SpriteBatch batch, String imageUri) {
		super(container);
		this.batch = batch;
		this.texture = new Texture(imageUri);
		this.sprite = new Sprite(texture);
		this.x = 0;
		this.y = 0;
		this.alpha = 0.0f;
	}

	@Override
	public void update() {
//		batch.draw(texture, x, Gdx.graphics.getHeight() - y);
		sprite.setX(x);
		sprite.setY(Gdx.graphics.getHeight() - y);
		sprite.draw(batch, alpha);
	}
	
	public float getWidth() { return texture.getWidth(); }
	public float getHeight() { return texture.getHeight(); }
	public float getX() { return x; }
	public void setX(float x) { this.x = x; }
	public float getY() { return y; }
	public void setY(float y) { this.y = y; }
}
