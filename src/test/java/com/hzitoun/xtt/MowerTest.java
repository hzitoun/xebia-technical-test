package com.hzitoun.xtt;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Position;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.enums.EnumDirection;

public class MowerTest {

	@Test
	public void testMowerTurnLeftWhenDirectionIsEast() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.E;
		final Mower mower = new Mower(pos, dir);
		mower.turnLeft();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

	@Test
	public void testMowerTurnLeftWhenDirectionIsWest() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.W;
		final Mower mower = new Mower(pos, dir);
		mower.turnLeft();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.S));
	}

	@Test
	public void testMowerTurnLeftWhenDirectionIsNorth() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.N;
		final Mower mower = new Mower(pos, dir);
		mower.turnLeft();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.W));
	}

	@Test
	public void testMowerTurnLeftWhenDirectionIsSouth() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.S;
		final Mower mower = new Mower(pos, dir);
		mower.turnLeft();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.E));
	}

	@Test
	public void testMowerTurnRightWhenDirectionIsEast() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.E;
		final Mower mower = new Mower(pos, dir);
		mower.turnRight();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.S));
	}

	@Test
	public void testMowerTurnRightWhenDirectionIsWest() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.W;
		final Mower mower = new Mower(pos, dir);
		mower.turnRight();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

	@Test
	public void testMowerTurnRightWhenDirectionIsNorth() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.N;
		final Mower mower = new Mower(pos, dir);
		mower.turnRight();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.E));
	}

	@Test
	public void testMowerTurnRightWhenDirectionIsSouth() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.S;
		final Mower mower = new Mower(pos, dir);
		mower.turnRight();
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.W));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsEast() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.E;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(2));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.E));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsWest() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.W;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(0));
		assertThat(mower.getPosition().getY(), equalTo(1));
		assertThat(mower.getDirection(), equalTo(EnumDirection.W));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsNorth() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.N;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(2));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsSouth() {
		final Position pos = new Position(1, 1);
		final EnumDirection dir = EnumDirection.S;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(1));
		assertThat(mower.getPosition().getY(), equalTo(0));
		assertThat(mower.getDirection(), equalTo(EnumDirection.S));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsEastAndPositionOutOfSurface() {
		final Position pos = new Position(6, 6);
		final EnumDirection dir = EnumDirection.E;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(6));
		assertThat(mower.getPosition().getY(), equalTo(6));
		assertThat(mower.getDirection(), equalTo(EnumDirection.E));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsWestAndPositionOutOfSurface() {
		final Position pos = new Position(0, 0);
		final EnumDirection dir = EnumDirection.W;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(0));
		assertThat(mower.getPosition().getY(), equalTo(0));
		assertThat(mower.getDirection(), equalTo(EnumDirection.W));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsNorthAndPositionOutOfSurface() {
		final Position pos = new Position(6, 6);
		final EnumDirection dir = EnumDirection.N;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(6));
		assertThat(mower.getPosition().getY(), equalTo(6));
		assertThat(mower.getDirection(), equalTo(EnumDirection.N));
	}

	@Test
	public void testMowerMoveForwardWhenDirectionIsSouthAndPositionOutOfSurface() {
		final Position pos = new Position(6, 0);
		final EnumDirection dir = EnumDirection.S;
		final Mower mower = new Mower(pos, dir);
		final Surface surface = new Surface(6, 6);
		mower.moveForward(surface);
		assertThat(mower.getPosition().getX(), equalTo(6));
		assertThat(mower.getPosition().getY(), equalTo(0));
		assertThat(mower.getDirection(), equalTo(EnumDirection.S));
	}

}
