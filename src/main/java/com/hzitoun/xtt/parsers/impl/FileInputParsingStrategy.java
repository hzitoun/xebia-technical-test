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
import com.hzitoun.xtt.parsers.InputParsingStrategy;
import com.hzitoun.xtt.utils.Utils;

/**
 * A Local file parsing strategy implementation.
 * 
 * @author hamed.zitoun
 *
 */
public class FileInputParsingStrategy implements InputParsingStrategy {

	private static final String PARSING_LINE_ERROR_KEY = "parsing.line.error";
	/**
	 * Used to parse mower's position and direction.
	 */
	private static final String MOWER_SEPARATOR = " ";
	/**
	 * Used to parse a surface's height and width.
	 */
	private static final String SURFACE_SEPARATOR = " ";

	@Override
	public final MowerAppCharacteristics parse(final String fileUrl) throws MowerAppException {
		final Path inputFile = new File(fileUrl).toPath();
		Surface surface = null;
		Mower mower = null;
		final Map<Mower, List<Command>> mowers = new LinkedHashMap<>();
		final List<String> lines = readLinesFromFile(inputFile);
		if (Utils.isEmpty(lines)) {
			return new MowerAppCharacteristics(surface, mowers);
		}
		for (int index = 0; index < lines.size(); index++) {
			final String line = lines.get(index);
			if (Utils.isBlank(line)) {
				throw new MowerAppException(Utils.getMessage(PARSING_LINE_ERROR_KEY, (index + 1)));
			}
			if (index == 0) {
				surface = parseSurface(index, line);
			} else if (index > 0 && index % 2 == 1) {
				mower = parseMower(index, line);
				if (index + 1 >= lines.size()) {
					mowers.put(mower, null);
				}
			} else if (index > 0 && index % 2 == 0) {
				mowers.put(mower, parseMowerCommands(mower, index, line));
			}
		}
		return new MowerAppCharacteristics(surface, mowers);
	}

	/**
	 * Constructs a surface object from the parsed line if possible (the file is
	 * well-formed).
	 * 
	 * @param index
	 *            the index of the line in the file.
	 * @param line
	 *            the line to parse
	 * @return A Surface
	 * @throws MowerAppException
	 */
	public final Surface parseSurface(final int index, final String line) throws MowerAppException {
		final String[] resolution = line.split(SURFACE_SEPARATOR);
		if (resolution.length == 2 && Utils.isNumeric(resolution[0]) && Utils.isNumeric(resolution[1])) {
			return new Surface(Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1]));
		} else {
			throw new MowerAppException(Utils.getMessage(PARSING_LINE_ERROR_KEY, (index + 1)));
		}
	}

	/**
	 * Constructs a mower object from the parsed line if possible (if the file
	 * is well-formed).
	 * 
	 * @param index
	 *            the index of the line in the file
	 * @param line
	 *            the line to parse.
	 * @return A mower
	 * @throws MowerAppException
	 *             thrown the file is not well-formed.
	 */
	public final Mower parseMower(final int index, final String line) throws MowerAppException {
		final String[] mowerCaracteristics = line.split(MOWER_SEPARATOR);
		if (mowerCaracteristics.length == 3 && Utils.isNumeric(mowerCaracteristics[0])
				&& Utils.isNumeric(mowerCaracteristics[1]) && Utils.isAlpha(mowerCaracteristics[2])
				&& EnumDirection.isDirectionValid(mowerCaracteristics[2])) {
			final EnumDirection direction = EnumDirection.valueOf(mowerCaracteristics[2].toUpperCase());
			final Position position = new Position(Integer.parseInt(mowerCaracteristics[0]),
					Integer.parseInt(mowerCaracteristics[1]));
			return new Mower(position, direction);
		} else {
			throw new MowerAppException(Utils.getMessage(PARSING_LINE_ERROR_KEY, (index + 1)));
		}
	}

	/**
	 * Constructs a list of commands from the parsed line.
	 * 
	 * @param mower
	 *            the mower to use to whom we should set the command.
	 * @param index
	 *            the index of the line to parse in the file.
	 * @param line
	 *            the line to parse.
	 * @return <code>{@literal List<Command>}</code>
	 * @throws MowerAppException
	 *             thrown the file is not well-formed.
	 */
	public final List<Command> parseMowerCommands(final Mower mower, int index, final String line)
			throws MowerAppException {
		final List<Command> commands = new ArrayList<>();
		for (final char commandAsChar : line.toCharArray()) {
			if (!EnumAction.isActionValid(commandAsChar)) {
				throw new MowerAppException(Utils.getMessage(PARSING_LINE_ERROR_KEY, (index + 1)));
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
		return commands;
	}

	/**
	 * Contructs a list of lines read from the file.
	 * 
	 * @param inputPath
	 *            file's path.
	 * @return file's lines as a List of string.
	 * @throws MowerAppException
	 *             thrown the file is is not present or if a technical exception
	 *             has occurred when attempting to read the file.
	 */
	private final List<String> readLinesFromFile(final Path inputPath) throws MowerAppException {
		try (final Stream<String> stream = Files.lines(inputPath)) {
			return stream.collect(Collectors.toList());
		} catch (final IOException e) {
			throw new MowerAppException(Utils.getMessage("parsing.file.exception", inputPath));
		}
	}

}
