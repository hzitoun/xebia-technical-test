package com.hzitoun.xtt.app;

import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.IMowerParser;

public class MowerApp {
	private IMowerParser parser;

	public MowerApp(final IMowerParser parser) {
		this.parser = parser;
	}
	
	public void start(final String inputFileUrl) throws MowerAppException {
		System.out.println("Starting app");
		System.out.println(parser.parseFile(inputFileUrl));
	}

	public void end() {
		System.out.println("Ending app");
	}

}
