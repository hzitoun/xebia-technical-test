package com.hzitoun.xtt.commands.impl;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

public class MoveForwardCommand implements Command {

	private Mower mower;

	public MoveForwardCommand(Mower mower) {
		this.mower = mower;
	}

	public void execute(final Surface surface) {
		mower.moveForward(surface);
	}

	@Override
	public String toString() {
		return "Move Forward Command";
	}
}