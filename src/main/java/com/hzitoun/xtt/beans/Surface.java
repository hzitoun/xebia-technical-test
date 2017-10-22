package com.hzitoun.xtt.beans;

public class Surface {

	private int heigth;
	private int width;

	public Surface(int heigth, int width) {
		super();
		this.heigth = heigth;
		this.width = width;
	}

	public final int getHeigth() {
		return heigth;
	}

	public final void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public final int getWidth() {
		return width;
	}

	public final void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Surface [heigth=");
		builder.append(heigth);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}

}
