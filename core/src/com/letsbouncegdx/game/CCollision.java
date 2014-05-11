package com.letsbouncegdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class CCollision extends Component {
	ArrayList<CFall> cfalls;
	Sound collisionSound;
	
	public CCollision(Entity entity, ArrayList<CFall> cfalls) {
		super(entity);
		this.cfalls = cfalls;
		this.collisionSound = Gdx.audio.newSound(Gdx.files.internal("data/collision.mp3"));
	}
	
	@Override
	public void update() {
	}
}
