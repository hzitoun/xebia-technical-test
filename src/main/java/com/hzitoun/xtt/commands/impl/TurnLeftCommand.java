package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

public class TurnLeftCommand implements Command {

	private Mower mower;

	public TurnLeftCommand(Mower mower) {
		this.mower = mower;
	}

	public void execute(final Surface surface) {
		mower.turnLeft(surface);
	}

	@Override
	public String toString() {
		return "Turn Left Command";
	}
}