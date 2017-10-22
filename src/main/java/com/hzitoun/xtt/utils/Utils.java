package com.hzitoun.xtt.utils;

import java.util.Collection;

public class Utils {

	private Utils() {
		new AssertionError("No private constructor for you!");
	}

	public static boolean isEmpty(final Collection<?> collection) {
		return null == collection || collection.isEmpty();
	}

	public static boolean isNotEmpty(final Collection<?> collection) {
		return !isEmpty(collection);
	}

}
