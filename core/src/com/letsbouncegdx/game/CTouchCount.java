package com.letsbouncegdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class CTouchCount extends Component {
	CTouch ctouch;
	CRender crender;
	int count;
	boolean touched;
	BitmapFont font;

	public CTouchCount(Entity entity, CTouch ctouch, CRender crender, int count, Color color) {
		super(entity);
		this.ctouch = ctouch;	
		this.crender = crender;
		this.count = count;
		this.font = new BitmapFont();
		this.font.setScale(5.0f);
		this.font.setColor(color);
	}
	
	@Override
	public void update() {
		if(!touched && ctouch.isTouching()) {
			count--;
			touched = true;
		}
		
		if(!ctouch.isTouching()) 
			touched = false;
		
		String strCount = count + "";
		
		font.draw(crender.batch, strCount, crender.getCenterX() - font.getBounds(strCount).width / 2, Gdx.graphics.getHeight() - crender.getCenterY() + font.getBounds(strCount).height / 2);

	}
}
