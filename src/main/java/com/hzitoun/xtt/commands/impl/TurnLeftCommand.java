package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.commands.Command;

public class TurnLeftCommand implements Command {

	private Mower mower;

	public TurnLeftCommand(Mower mower) {
		this.mower = mower;
	}

	public void execute() {
		mower.turnLeft();
	}

	@Override
	public String toString() {
		return "Turn Left Command";
	}
}