package com.hzitoun.xtt;

import com.hzitoun.xtt.app.MowerApp;
import com.hzitoun.xtt.app.MowerAppFactory;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.IMowerParser;
import com.hzitoun.xtt.parsers.impl.MowerParserIpml;

public class XttApplication {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Input file must be specified as an argument for this jar!");
			return;
		}
		final String fileInput = args[0];
		final IMowerParser parser = new MowerParserIpml();
		final MowerApp app = MowerAppFactory.getInstance(parser);
		try {
			app.start(fileInput);
			app.end();
		} catch (final MowerAppException e) {
			System.err.println("error");
			e.printStackTrace();
		}
	}
}
