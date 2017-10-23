package com.hzitoun.xtt.commands;

import com.hzitoun.xtt.beans.Surface;

/***
 * Abstract command to control the mower.
 * 
 * @author hamed.zitoun
 */
public interface Command {
	/**
	 * Executes the command.
	 * 
	 * @param surface
	 *            the surface where a mower has to work.
	 */
	void execute(Surface surface);
}