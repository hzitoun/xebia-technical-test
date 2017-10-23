package com.hzitoun.xtt.utils;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * final utility class offering some utility methods.
 * 
 * @author hamed.zitoun
 *
 */
public final class Utils {

	/**
	 * the bundle's name where we store all the app's messages.
	 */
	private static final String BUNDLE_NAME = "application";
	/**
	 * An instance of a resource bundle (No need to create more than one).
	 */
	private static final ResourceBundle messages = ResourceBundle.getBundle(BUNDLE_NAME, Locale.FRANCE);

	/**
	 * Private constructor preventing class instance creation.
	 */
	private Utils() {
	}

	/**
	 * Returns a message.
	 * 
	 * @param key
	 *            the key to look for in the bundle.
	 * @return the value corresponding the to the given key.
	 */
	public static final String getMessage(final String key) {
		return messages.getString(key);
	}

	/**
	 * Returns a message.
	 * 
	 * @param key
	 *            the key to look for in the bundle.
	 * @param arguments
	 *            Arguments used to build the final message.
	 * @return the value corresponding the to the given key.
	 */
	public static final String getMessage(final String key, final Object... arguments) {
		return MessageFormat.format(getMessage(key), arguments);
	}

	/**
	 * Checks if a collection is empty.
	 * 
	 * @param collection
	 *            collection to check.
	 * @return <code>boolean</code>
	 */
	public static boolean isEmpty(final Collection<?> collection) {
		return null == collection || collection.isEmpty();
	}

	/**
	 * Checks if a collection is NOT empty.
	 * 
	 * @param collection
	 *            collection to check.
	 * @return <code>boolean</code>
	 */
	public static boolean isNotEmpty(final Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * Checks if a map is NOT empty.
	 * 
	 * @param map
	 *            map to check.
	 * @return <code>boolean</code>
	 */
	public static boolean isNotEmpty(final Map<?, ?> map) {
		return !isEmpty(map);
	}

	/**
	 * Checks if a map is empty.
	 * 
	 * @param map
	 *            map to check.
	 * @return <code>boolean</code>
	 */
	public static boolean isEmpty(final Map<?, ?> map) {
		return null == map || map.isEmpty();
	}

	/**
	 * Checks if a charsequence is blank.
	 * 
	 * @param cs
	 *            charsequence to check.
	 * @return <code>boolean</code>
	 */
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

	/**
	 * Checks if a charsequence is numeric.
	 * 
	 * @param cs
	 *            charsequence to check.
	 * @return <code>boolean</code>
	 */
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

	/**
	 * Checks if a charsequence is alpha.
	 * 
	 * @param cs
	 *            charsequence to check.
	 * @return <code>boolean</code>
	 */
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

	/**
	 * Checks if a charsequence is empty.
	 * 
	 * @param cs
	 *            charsequence to check.
	 * @return <code>boolean</code>
	 */
	private static boolean isEmpty(CharSequence cs) {
		return (cs == null || cs.length() == 0);
	}

}
