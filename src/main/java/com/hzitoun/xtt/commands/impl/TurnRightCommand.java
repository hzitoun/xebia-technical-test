package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

/**
 * This command tells the mower to turn right.
 * 
 * @author hamed.zitoun
 *
 */
public class TurnRightCommand implements Command {

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
	public TurnRightCommand(Mower mower) {
		this.mower = mower;
	}

	@Override
	public void execute(final Surface surface) {
		mower.turnRight();
	}

	@Override
	public String toString() {
		return "Turn Right Command";
	}
}