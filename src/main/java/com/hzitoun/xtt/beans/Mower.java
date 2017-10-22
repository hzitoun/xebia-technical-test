package com.hzitoun.xtt.beans;

import java.util.UUID;

import com.hzitoun.xtt.enums.EnumDirection;

/**
 * This class represents a Mower characterized by its position, direction and
 * id.
 * 
 * @author hamed.zitoun.
 */
public class Mower {

	/**
	 * Direction of the mower.
	 */
	private EnumDirection direction;
	/**
	 * Position of the mower.
	 */
	private Position position;
	/**
	 * Position's id.
	 */
	private String id;

	/**
	 * Consturctor.
	 * 
	 * @param position
	 *            the starting position
	 * @param direction
	 *            the starting direction
	 */
	public Mower(final Position position, final EnumDirection direction) {
		this.direction = direction;
		this.position = position;
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Turns the mower 90° depending on its direction.
	 * 
	 * @param surface
	 *            the surface where the mower should move.
	 */
	public void turnLeft(final Surface surface) {
		if (EnumDirection.N.equals(direction)) {
			direction = EnumDirection.W;
		} else if (EnumDirection.S.equals(direction)) {
			direction = EnumDirection.E;
		} else if (EnumDirection.E.equals(direction)) {
			direction = EnumDirection.N;
		} else if (EnumDirection.W.equals(direction)) {
			direction = EnumDirection.S;
		}
	}

	/**
	 * Turns the mower 90° depending on its direction.
	 * 
	 * @param surface
	 *            the surface where the mower should move.
	 */
	public void turnRight(final Surface surface) {
		if (EnumDirection.N.equals(direction)) {
			direction = EnumDirection.E;
		} else if (EnumDirection.S.equals(direction)) {
			direction = EnumDirection.W;
		} else if (EnumDirection.E.equals(direction)) {
			direction = EnumDirection.S;
		} else if (EnumDirection.W.equals(direction)) {
			direction = EnumDirection.N;
		}
	}

	/**
	 * Moves the mower forward depending on its direction.
	 * 
	 * @param surface
	 *            the surface where the mower should move.
	 */
	public void moveForward(final Surface surface) {
		if (EnumDirection.N.equals(direction) && position.getY() + 1 <= surface.getHeight()) {
			position.setY(position.getY() + 1);
		} else if (EnumDirection.S.equals(direction) && position.getY() - 1 >= 0) {
			position.setY(position.getY() - 1);
		} else if (EnumDirection.E.equals(direction) && position.getX() + 1 <= surface.getWidth()) {
			position.setX(position.getX() + 1);
		} else if (EnumDirection.W.equals(direction) && position.getX() - 1 >= 0) {
			position.setX(position.getX() - 1);
		}
	}

	public void printPositionAndOrientation() {
		System.out.println(String.format("%d %d %s", position.getX(), position.getY(), direction));
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
