package com.hzitoun.xtt.beans;

import java.util.UUID;

import com.hzitoun.xtt.enums.EnumDirection;

/**
 * @author hamed.zitoun
 *
 */
public class Mower {

	private EnumDirection direction;
	private Position position;
	private String id;

	public Mower(final Position position, final EnumDirection direction) {
		this.direction = direction;
		this.position = position;
		this.id = UUID.randomUUID().toString();
	}

	public void turnLeft() {
		// TODO
	}

	public void turnRight() {
		// TODO
	}

	public void moveForward() {
		// TODO
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mower [direction=");
		builder.append(direction);
		builder.append(", position=");
		builder.append(position);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
