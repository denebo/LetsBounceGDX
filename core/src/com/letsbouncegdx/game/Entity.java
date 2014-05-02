package com.letsbouncegdx.game;

import java.util.LinkedList;

public class Entity {
	LinkedList<IComponent> components = new LinkedList<IComponent>();
	public Entity() { }
	public Entity(Iterable<IComponent> components) {
		for(IComponent c : components)
			addComponent(c);
	}
	
	public void addComponent(IComponent component) {
		components.add(component);
	}
	
	public void update() {
		for(IComponent c : components)
			c.update();
	}
}
