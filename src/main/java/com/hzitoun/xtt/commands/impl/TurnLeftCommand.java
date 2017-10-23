package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

/**
 * This command tells the mower to turn left.
 * 
 * @author hamed.zitoun
 *
 */
public class TurnLeftCommand implements Command {

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
	public TurnLeftCommand(Mower mower) {
		this.mower = mower;
	}

	@Override
	public void execute(final Surface surface) {
		mower.turnLeft();
	}

	@Override
	public String toString() {
		return "Turn Left Command";
	}
}