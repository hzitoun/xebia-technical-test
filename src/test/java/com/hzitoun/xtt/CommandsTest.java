package com.hzitoun.xtt;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Position;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;
import com.hzitoun.xtt.commands.impl.MoveForwardCommand;
import com.hzitoun.xtt.commands.impl.TurnLeftCommand;
import com.hzitoun.xtt.commands.impl.TurnRightCommand;
import com.hzitoun.xtt.enums.EnumDirection;

public class CommandsTest {

	@Test
	public void testTurnLeftCommand() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.E;
		final Mower mower = new Mower(pos, dir);
		final Command command = new TurnLeftCommand(mower);
		final Surface surface = new Surface(6, 6);
		command.execute(surface);
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

	@Test
	public void testTurnRightCommand() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.W;
		final Mower mower = new Mower(pos, dir);
		final Command command = new TurnRightCommand(mower);
		final Surface surface = new Surface(6, 6);
		command.execute(surface);
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

	@Test
	public void testMoveForwardCommand() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.N;
		final Mower mower = new Mower(pos, dir);
		final Command command = new MoveForwardCommand(mower);
		final Surface surface = new Surface(6, 6);
		command.execute(surface);
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(2));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

}
