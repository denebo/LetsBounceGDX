package com.letsbouncegdx.game;

import java.util.LinkedList;
import java.util.List;

public class Scene {
	public GameClass game;
	public LinkedList<Entity> entities; 
	
	public Scene(GameClass game) {
		this.entities = new LinkedList<Entity>();
		this.game = game;
	}
	
	public void update() {
		for(Entity e : entities)
			e.update();
	}
}
