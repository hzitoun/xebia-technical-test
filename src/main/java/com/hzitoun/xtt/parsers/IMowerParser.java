package com.hzitoun.xtt.parsers;

import java.util.List;

import com.hzitoun.xtt.app.MowerAppCharacteristics;
import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.beans.Surface;
import com.hzitoun.xtt.commands.Command;
import com.hzitoun.xtt.exceptions.MowerAppException;

public interface IMowerParser {
	MowerAppCharacteristics parseFile(String filePath) throws MowerAppException;

	Surface parseSurface(int index, String line) throws MowerAppException;

	Mower parseMower(int index, String line) throws MowerAppException;

	List<Command> parseMowerCommands(Mower mower, int index, String line) throws MowerAppException;
}
