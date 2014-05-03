package com.letsbouncegdx.game;

import com.badlogic.gdx.Input;

public class InputHandler {
	Input input;

	public InputHandler(Input input) {
		this.input = input;
	}
	
	public boolean isTouched() {
		return input.isTouched();
	}
	
	public int getTouchX() {
        return input.getX();
	}
	
	public int getTouchY() {
		return input.getY();
	}
}
