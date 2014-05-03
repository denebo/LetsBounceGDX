/*
 * Components.java
 * 
 * Components are building blocks that help form an Entity.
 * A component applied to an entity defined a specific
 * property for that Entity.
 * 
 */

package com.letsbouncegdx.game;

public abstract class Component {
	public Entity entity;
	
	// Component constructor convention is
	// Entity, Components, Component specific fields
	public Component(Entity entity) {
		this.entity = entity;
	}
	
	abstract void update();
}
