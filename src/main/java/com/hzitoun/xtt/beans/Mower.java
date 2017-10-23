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
	 */
	public void turnLeft() {
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
	 */
	public void turnRight() {
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

	/**
	 * @return the direction
	 */
	public final EnumDirection getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public final void setDirection(EnumDirection direction) {
		this.direction = direction;
	}

	/**
	 * @return the position
	 */
	public final Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public final void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%d %d %s", position.getX(), position.getY(), direction);
	}

}
