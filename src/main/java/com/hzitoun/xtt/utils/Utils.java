package com.hzitoun.xtt.utils;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

public class Utils {

	private static final String BUNDLE_NAME = "application";
	private static final ResourceBundle messages = ResourceBundle.getBundle(BUNDLE_NAME, Locale.FRANCE);

	private Utils() {
		new AssertionError("No private constructor for you!");
	}

	public static final String getMessage(final String key) {
		return messages.getString(key);
	}

	public static final String getMessage(final String key, final Object... arguments) {
		return MessageFormat.format(getMessage(key), arguments);
	}

	public static boolean isEmpty(final Collection<?> collection) {
		return null == collection || collection.isEmpty();
	}

	public static boolean isNotEmpty(final Collection<?> collection) {
		return !isEmpty(collection);
	}

	public static boolean isBlank(final CharSequence cs) {
		if (isEmpty(cs)) {
			return true;
		}
		for (int i = 0; i < cs.length(); i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlpha(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetter(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isEmpty(CharSequence cs) {
		return (cs == null || cs.length() == 0);
	}

}
