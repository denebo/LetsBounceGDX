package com.letsbouncegdx.game;

import java.util.LinkedList;

public class Entity {
	LinkedList<Component> components;
	public Entity() {
		initialize(); 
	}

	public Entity(Iterable<Component> components) {
		initialize();
		for(Component c : components)
			addComponent(c);
	}
	
	private void initialize() {
		components = new LinkedList<Component>();
	}
	
	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void update() {
		for(Component c : components)
			c.update();
	}
}
