package com.hzitoun.xtt.enums;

public enum EnumAction {
	A('A'), G('G'), D('D');

	private char label;

	private EnumAction(char label) {
		this.label = label;
	}

	public static boolean isActionValid(final char actionAsString) {
		for (final EnumAction action : values()) {
			if (action.label == actionAsString) {
				return true;
			}
		}
		return false;
	}
}
