package com.letsbouncegdx.game;

import java.util.LinkedList;
import java.util.List;

public class Scene {
	LinkedList<Entity> entities; 
	
	public Scene() {
		initialize();
	}
	
	public Scene(List<Entity> entities) {
		this.entities = (LinkedList<Entity>)entities;
	}
	
	private void initialize() {
		entities = new LinkedList<Entity>();
	}
	
	public void update() {
		for(Entity e : entities)
			e.update();
	}
}
