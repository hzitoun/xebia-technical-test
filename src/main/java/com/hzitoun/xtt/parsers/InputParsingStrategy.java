package com.hzitoun.xtt.parsers;

import com.hzitoun.xtt.app.MowerAppCharacteristics;
import com.hzitoun.xtt.exceptions.MowerAppException;

/**
 * Abstract Parsing strategy. It is the mower app the possibility to change
 * parsing strategy at runtime (so without need to modify the code).
 * 
 * @author hamed.zitoun
 *
 */
public interface InputParsingStrategy {
	/**
	 * 
	 * Parses the inputs needed to fire the mower application.
	 * 
	 * @param inputs
	 *            inputs than can be either a path of a local file,a distant
	 *            file's URL, a data as string...etc.
	 * @return A mower app's characteristics.
	 * @throws MowerAppException
	 *             thrown when an exception occurs while parsing the inputs.
	 */
	MowerAppCharacteristics parse(String inputs) throws MowerAppException;
}
