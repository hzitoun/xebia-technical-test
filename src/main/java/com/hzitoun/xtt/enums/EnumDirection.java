package com.hzitoun.xtt.enums;

/**
 * This enum holds all the possible values of a mower's Direction.
 * 
 * @author hamed.zitoun
 *
 */
public enum EnumDirection {

	/**
	 * NORTH.
	 */
	N("N"),
	/**
	 * EAST
	 */
	E("E"),
	/**
	 * WEST
	 */
	W("W"),
	/**
	 * SOUTH
	 */
	S("S");

	/**
	 * A direction's label.
	 */
	private String label;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            label
	 */
	private EnumDirection(String label) {
		this.label = label;
	}

	/**
	 * Returns true of the passed argument corresponds to a valid mower's
	 * direction.
	 * 
	 * @param directionAsString
	 *            mower's direction as a String
	 * @return true if the direction is valid.
	 */
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
