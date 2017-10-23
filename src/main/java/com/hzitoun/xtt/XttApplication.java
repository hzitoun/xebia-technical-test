package com.hzitoun.xtt;

import com.hzitoun.xtt.app.MowerApp;
import com.hzitoun.xtt.app.MowerAppFactory;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.InputParsingStrategy;
import com.hzitoun.xtt.parsers.impl.FileInputParsingStrategy;

/**
 * The jar's entry point to start the program; the mower app in our case.
 * 
 * @author hamed.zitoun
 *
 */
public class XttApplication {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Input file must be specified as an argument for this program.");
			return;
		}
		final String input = args[0];
		final MowerApp app = MowerAppFactory.createApp();
		final InputParsingStrategy strategy = new FileInputParsingStrategy();
		app.setParsingStrategy(strategy);
		try {
			app.start(input);
		} catch (final MowerAppException e) {
			System.err.println("An exception has occurred when running the application " + e);
		}
	}
}
