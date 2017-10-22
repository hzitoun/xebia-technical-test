package com.hzitoun.xtt.enums;

public enum EnumDirection {

	N("N"), E("E"), W("W"), S("S");

	private String label;

	private EnumDirection(String label) {
		this.label = label;
	}

	public static boolean isDirectionValid(final String directionAsString) {
		if (null == directionAsString) {
			return false;
		}
		for (final EnumDirection direction : values()) {
			if (direction.label.equalsIgnoreCase(directionAsString)) {
				return true;
			}
		}
		return false;
	}

}
