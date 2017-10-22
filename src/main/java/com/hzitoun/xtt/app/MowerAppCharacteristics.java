package com.hzitoun.xtt.app;

import java.util.List;
import java.util.Map;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

public class MowerAppCharacteristics {

	private Surface surface;
	private Map<Mower, List<Command>> mowers;

	/**
	 * @param surface
	 * @param mowers
	 */
	public MowerAppCharacteristics(final Surface surface, final Map<Mower, List<Command>> mowers) {
		super();
		this.surface = surface;
		this.mowers = mowers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MowerAppCharacteristics [surface=");
		builder.append(surface);
		builder.append(", mowers=");
		builder.append(mowers);
		builder.append("]");
		return builder.toString();
	}

}
