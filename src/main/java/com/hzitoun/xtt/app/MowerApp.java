package com.hzitoun.xtt.app;

import java.util.List;
import java.util.Map;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.InputParsingStrategy;
import com.hzitoun.xtt.utils.Utils;

/**
 * This class represents the Mower Application.
 * 
 * @author hamed.zitoun
 *
 */
public class MowerApp {

	/**
	 * The strategy to use to parse the app inputs.
	 */
	private InputParsingStrategy parsingStrategy;

	/**
	 * Gives the possibility to change the parsing strategy at runtime.
	 * 
	 * @param strategy
	 *            strategy to use to parse the app inputs
	 */
	public void setParsingStrategy(final InputParsingStrategy strategy) {
		this.parsingStrategy = strategy;
	}

	/**
	 * Starts the application.
	 * 
	 * @param input
	 *            app's input than can be either a local file's path, a web URL,
	 *            a data as string...etc.
	 * @throws MowerAppException
	 *             the exception thrown when a problem occurs.
	 */
	public void start(final String input) throws MowerAppException {
		if (null == this.parsingStrategy) {
			throw new MowerAppException(Utils.getMessage("parsing.strategy.undefined"));
		}
		final MowerAppCharacteristics appCharacts = this.parsingStrategy.parse(input);
		if (null != appCharacts) {
			final Surface surface = appCharacts.getSurface();
			if (null != surface) {
				final Map<Mower, List<Command>> mowers = appCharacts.getMowers();
				if (Utils.isNotEmpty(mowers)) {
					mowers.forEach((mower, commands) -> {
						if (Utils.isNotEmpty(commands)) {
							commands.forEach(command -> command.execute(surface));
						}
						System.out.println(mower);
					});
				}
			}
		}
	}
}
