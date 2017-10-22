package com.hzitoun.xtt.beans;

/**
 * This class represents a mower's position.
 * 
 * @author hamed.zitoun
 *
 */
public class Position {
	/**
	 * x coordinate
	 */
	private int x;
	/**
	 * y coordinate
	 */
	private int y;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public final int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public final void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public final int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public final void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Position [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}

}
