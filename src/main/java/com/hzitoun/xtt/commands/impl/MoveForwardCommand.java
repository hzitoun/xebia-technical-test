package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

/**
 * This command tells the mower to move forward.
 * 
 * @author hamed.zitoun
 *
 */
public class MoveForwardCommand implements Command {

	/**
	 * the mower to control.
	 */
	private Mower mower;

	/**
	 * Constructor.
	 * 
	 * @param mower
	 *            the mower
	 */
	public MoveForwardCommand(final Mower mower) {
		this.mower = mower;
	}

	@Override
	public void execute(final Surface surface) {
		mower.moveForward(surface);
	}

	@Override
	public String toString() {
		return "Move Forward Command";
	}
}