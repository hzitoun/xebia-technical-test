package com.hzitoun.xtt.app;

import java.util.List;
import java.util.Map;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;

/**
 * This class holds the mower app's Characteristics
 * 
 * @author hamed.zitoun
 *
 */
public class MowerAppCharacteristics {

	/**
	 * The grass surface where the mowers have to work.
	 */
	private Surface surface;
	/**
	 * A map of mower and list command to execute.
	 */
	private Map<Mower, List<Command>> mowers;

	/**
	 * Contructor.
	 * 
	 * @param surface
	 *            the surface
	 * @param mowers
	 *            the mowers
	 */
	public MowerAppCharacteristics(final Surface surface, final Map<Mower, List<Command>> mowers) {
		super();
		this.surface = surface;
		this.mowers = mowers;
	}

	/**
	 * @return the surface
	 */
	public final Surface getSurface() {
		return surface;
	}

	/**
	 * @param surface
	 *            the surface to set
	 */
	public final void setSurface(Surface surface) {
		this.surface = surface;
	}

	/**
	 * @return the mowers
	 */
	public final Map<Mower, List<Command>> getMowers() {
		return mowers;
	}

	/**
	 * @param mowers
	 *            the mowers to set
	 */
	public final void setMowers(Map<Mower, List<Command>> mowers) {
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
