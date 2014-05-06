package com.letsbouncegdx.game;

import java.util.ArrayList;
import java.util.LinkedList;

public class Entity {
	Scene scene;
	LinkedList<Component> components;

	public Entity(Scene scene) {
		this.scene = scene;
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
