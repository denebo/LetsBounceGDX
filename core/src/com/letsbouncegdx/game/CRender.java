package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CRender extends Component {
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	public float x;
	public float y;
	public float alpha;

	public CRender(Entity container, SpriteBatch batch, String imageUri, float x, float y, float alpha) {
		super(container);
		this.batch = batch;
		this.texture = new Texture(imageUri);
		this.sprite = new Sprite(texture);
		this.x = x;
		this.y = y;
		this.alpha = alpha;
	}

	@Override
	public void update() {
//		batch.draw(texture, x, Gdx.graphics.getHeight() - y);
		sprite.setX(x);
		sprite.setY(Gdx.graphics.getHeight() - sprite.getHeight() - y);
		sprite.draw(batch, alpha);
	}
	
	public float getWidth() { return texture.getWidth(); }
	public float getHeight() { return texture.getHeight(); }
}
