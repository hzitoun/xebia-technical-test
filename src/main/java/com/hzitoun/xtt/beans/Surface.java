package com.hzitoun.xtt.beans;

/**
 * This class represents the grass surface where the mowers should work.
 * 
 * @author hamed.zitoun
 *
 */
public class Surface {

	/**
	 * height.
	 */
	private int height;
	/**
	 * width.
	 */
	private int width;

	/**
	 * @param height
	 *            surface's height
	 * @param width
	 *            surface's width
	 */
	public Surface(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public final int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public final void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public final int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public final void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Surface [height=");
		builder.append(height);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}

}
