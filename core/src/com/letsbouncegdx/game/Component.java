package com.letsbouncegdx.game;

public abstract class Component {
	public Entity entity;
	
	public Component(Entity entity) {
		this.entity = entity;
	}
	
	abstract void update();
}
