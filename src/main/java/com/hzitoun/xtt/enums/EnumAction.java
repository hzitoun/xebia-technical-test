package com.hzitoun.xtt.enums;

/**
 * This enum holds all the possible values of the action given to a mower.
 * 
 * @author hamed.zitoun
 *
 */
public enum EnumAction {
	A('A'), G('G'), D('D');

	/**
	 * An action's label.
	 */
	private char label;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            label
	 */
	private EnumAction(char label) {
		this.label = label;
	}

	/**
	 * Returns true of the passed argument corresponds to a valid action.
	 * 
	 * @param actionAsChar
	 *            action as Char
	 * 
	 * @return true if the action is valid.
	 */
	public static boolean isActionValid(final char actionAsChar) {
		for (final EnumAction action : values()) {
			if (action.label == actionAsChar) {
				return true;
			}
		}
		return false;
	}
}
