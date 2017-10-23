package com.hzitoun.xtt.exceptions;

/**
 * Represents a technical exception of the mower app.
 * 
 * @author hamed.zitoun
 *
 */
public class MowerAppException extends Exception {

	/**
	 * Serial VUID.
	 */
	private static final long serialVersionUID = 20172210L;

	/**
	 * Constructor.
	 * 
	 * @param msg
	 *            the message
	 */
	public MowerAppException(final String msg) {
		super(msg);
	}

}
