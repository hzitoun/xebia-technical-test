package com.hzitoun.xtt;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.hzitoun.xtt.app.MowerAppCharacteristics;
import com.hzitoun.xtt.beans.Mower;
import com.hzitoun.xtt.commands.Command;
import com.hzitoun.xtt.commands.impl.MoveForwardCommand;
import com.hzitoun.xtt.commands.impl.TurnLeftCommand;
import com.hzitoun.xtt.commands.impl.TurnRightCommand;
import com.hzitoun.xtt.enums.EnumDirection;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.IMowerParser;
import com.hzitoun.xtt.parsers.impl.MowerParserIpml;
import com.hzitoun.xtt.utils.Utils;

public class ParserTests {

	private IMowerParser parser;
	private ClassLoader classLoader = getClass().getClassLoader();

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		parser = new MowerParserIpml();

	}

	@Test
	public void testFailWhenFileNotFound() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(startsWith(Utils.getMessage("parsing.file.exception", "")));
		parser.parseFile("NOTEXISTING_FILE.txt");
	}

	@Test
	public void testFailWhenSurfaceNotWellFormed() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 1)));
		final String file = classLoader.getResource("bad_input_1.txt").getFile();
		parser.parseFile(file);
	}

	@Test
	public void testFailWhenMowerNotWellFormed() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 2)));
		final String file = classLoader.getResource("bad_input_2.txt").getFile();
		parser.parseFile(file);
	}

	@Test
	public void testFailWhenCommandsNotWellFormed() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 3)));
		final String file = classLoader.getResource("bad_input_3.txt").getFile();
		parser.parseFile(file);
	}

	@Test
	public void testFailWhenFileEmpty() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.file.empty.error")));
		final String file = classLoader.getResource("empty_input.txt").getFile();
		parser.parseFile(file);
	}

	@Test
	public void testSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			parser.parseFile(file);
		} catch (MowerAppException e) {
			fail("Parser can't parse a well-formed file!");
		}
	}

	@Test
	public void testSurfaceParsingSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			final MowerAppCharacteristics characts = parser.parseFile(file);
			assertNotNull(characts);
			assertNotNull(characts.getSurface());
			assertThat(characts.getSurface().getHeight(), equalTo(5));
			assertThat(characts.getSurface().getWidth(), equalTo(5));
		} catch (MowerAppException e) {
			fail("Parser can't parse a well-formed file!");
		}
	}

	@Test
	public void testMowerParsingSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			final MowerAppCharacteristics characts = parser.parseFile(file);
			assertNotNull(characts);
			assertNotNull(characts.getMowers());
			assertThat(characts.getMowers().size(), equalTo(2));
			final Iterator<Mower> iterator = characts.getMowers().keySet().iterator();
			final Mower firstMower = iterator.next();
			assertNotNull(firstMower.getPosition());
			assertThat(firstMower.getPosition().getX(), equalTo(1));
			assertThat(firstMower.getPosition().getY(), equalTo(2));
			assertThat(firstMower.getDirection(), equalTo(EnumDirection.N));
			final Mower secondMower = iterator.next();
			assertNotNull(secondMower.getPosition());
			assertThat(secondMower.getPosition().getX(), equalTo(3));
			assertThat(secondMower.getPosition().getY(), equalTo(3));
			assertThat(secondMower.getDirection(), equalTo(EnumDirection.E));
		} catch (MowerAppException e) {
			fail("Parser can't parse a well-formed file!");
		}
	}

	@Test
	public void testCommandsParsingSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			final MowerAppCharacteristics characts = parser.parseFile(file);
			assertNotNull(characts);
			final Iterator<List<Command>> iterator = characts.getMowers().values().iterator();
			final List<Command> firstMower = iterator.next();
			assertNotNull(firstMower);
			assertThat(firstMower.size(), equalTo(3));
			assertThat(firstMower.get(0), instanceOf(TurnLeftCommand.class));
			assertThat(firstMower.get(1), instanceOf(MoveForwardCommand.class));
			assertThat(firstMower.get(2), instanceOf(TurnRightCommand.class));
			final List<Command> secondMower = iterator.next();
			assertNotNull(secondMower);
			assertThat(secondMower.size(), equalTo(3));
			assertThat(secondMower.get(0), instanceOf(MoveForwardCommand.class));
			assertThat(secondMower.get(1), instanceOf(TurnRightCommand.class));
			assertThat(secondMower.get(2), instanceOf(TurnLeftCommand.class));
		} catch (MowerAppException e) {
			fail("Parser can't parse a well-formed file!");
		}
	}
}
