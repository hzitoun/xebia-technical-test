package com.hzitoun.xtt.app;

import com.hzitoun.xtt.parsers.IMowerParser;

public class MowerAppFactory {

	private static MowerApp instance;

	public static MowerApp getInstance(IMowerParser parser) {
		if (instance == null) {
			instance = new MowerApp(parser);
		}
		return instance;
	}

}
