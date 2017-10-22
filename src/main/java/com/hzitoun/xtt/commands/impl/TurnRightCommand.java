package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.commands.Command;

public class TurnRightCommand implements Command {

	private Mower mower;

	public TurnRightCommand(Mower mower) {
		this.mower = mower;
	}

	public void execute() {
		mower.turnRight();
	}

	@Override
	public String toString() {
		return "Turn Right Command";
	}
}