package com.hzitoun.xtt.parsers.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.hzitoun.xtt.app.MowerAppCharacteristics;
import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Position;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;
import com.hzitoun.xtt.commands.impl.MoveForwardCommand;
import com.hzitoun.xtt.commands.impl.TurnLeftCommand;
import com.hzitoun.xtt.commands.impl.TurnRightCommand;
import com.hzitoun.xtt.enums.EnumAction;
import com.hzitoun.xtt.enums.EnumDirection;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.IMowerParser;
import com.hzitoun.xtt.utils.Utils;

public class MowerParserIpml implements IMowerParser {

	public MowerAppCharacteristics parse(final String fileUrl) throws MowerAppException {
		final Path inputFile = new File(fileUrl).toPath();
		Surface surface = null;
		Mower mower = null;
		final Map<Mower, List<Command>> mowers = new LinkedHashMap<>();
		try {
			final List<String> lines = readLinesFromFile(inputFile);
			if (Utils.isNotEmpty(lines)) {
				for (int index = 0; index < lines.size(); index++) {
					final String line = lines.get(index);
					if (Utils.isBlank(line)) {
						throw new MowerAppException("Your file is not well formated at line " + (index + 1));
					}
					if (index == 0) {
						surface = parseSurface(index, line);
					} else if (index > 0 && index % 2 == 1) {
						mower = parseMower(lines, index, line);
					} else if (index > 0 && index % 2 == 0) {
						parseMowerCommands(mower, mowers, index, line);
					}
				}
				final MowerAppCharacteristics app = new MowerAppCharacteristics(surface, mowers);
				return app;
			} else {
				throw new MowerAppException("Your file seems to be empty");
			}
		} catch (final IOException e) {
			e.printStackTrace();
			throw new MowerAppException("An exception has occurred when reading the file");

		}
	}

	private final void parseMowerCommands(final Mower mower, final Map<Mower, List<Command>> mowers, int index,
			final String line) throws MowerAppException {
		final List<Command> commands = new ArrayList<>();
		for (final char commandAsChar : line.toCharArray()) {
			if (!EnumAction.isActionValid(commandAsChar)) {
				throw new MowerAppException("Your file is not well formated at line " + (index + 1));
			}
			final EnumAction action = EnumAction.valueOf(String.valueOf(commandAsChar));
			if (EnumAction.A.equals(action)) {
				commands.add(new MoveForwardCommand(mower));
			} else if (EnumAction.G.equals(action)) {
				commands.add(new TurnLeftCommand(mower));
			} else if (EnumAction.D.equals(action)) {
				commands.add(new TurnRightCommand(mower));
			}
		}
		mowers.put(mower, commands);
	}

	private final Mower parseMower(final List<String> lines, final int index, final String line)
			throws MowerAppException {
		final String[] mowerCaracteristics = line.split(" ");
		if (mowerCaracteristics.length == 3 && Utils.isNumeric(mowerCaracteristics[0])
				&& Utils.isNumeric(mowerCaracteristics[1]) && Utils.isAlpha(mowerCaracteristics[2])
				&& EnumDirection.isDirectionValid(mowerCaracteristics[2])) {
			final EnumDirection direction = EnumDirection.valueOf(mowerCaracteristics[2].toUpperCase());
			final Position position = new Position(Integer.parseInt(mowerCaracteristics[0]),
					Integer.parseInt(mowerCaracteristics[1]));
			if (index + 1 >= lines.size()) {
				throw new MowerAppException("Missing commands for the last mower ");
			}
			return new Mower(position, direction);
		} else {
			throw new MowerAppException("Your file is not well formated at line " + (index + 1));
		}
	}

	private final Surface parseSurface(final int index, final String line) throws MowerAppException {
		final String[] resolution = line.split(" ");
		if (resolution.length == 2 && Utils.isNumeric(resolution[0]) && Utils.isNumeric(resolution[1])) {
			return new Surface(Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1]));
		} else {
			throw new MowerAppException("Your file is not well formated at line " + (index + 1));
		}
	}

	private final List<String> readLinesFromFile(final Path inputFile) throws IOException {
		try (final Stream<String> stream = Files.lines(inputFile)) {
			return stream.collect(Collectors.toList());
		}
	}

}
