package com.hzitoun.xtt.app;

import java.util.List;
import java.util.Map;

import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.IMowerParser;
import com.hzitoun.xtt.utils.Utils;

public class MowerApp {
	private IMowerParser parser;

	public MowerApp(final IMowerParser parser) {
		this.parser = parser;
	}

	public void start(final String inputFileUrl) throws MowerAppException {
		System.out.println("Starting app");
		final MowerAppCharacteristics appCharacts = parser.parseFile(inputFileUrl);
		if (appCharacts != null) {
			System.out.println("App started");
			final Surface surface = appCharacts.getSurface();
			final Map<Mower, List<Command>> mowers = appCharacts.getMowers();
			if (Utils.isNotEmpty(mowers)) {
				mowers.forEach((mower, commands) -> {
					if (Utils.isNotEmpty(commands)) {
						commands.forEach(command -> command.execute(surface));
					}
					mower.printPositionAndOrientation();
				});
			}
		}
		System.out.println("Done!");
	}
}
