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
import com.hzitoun.xtt.parsers.MowerAppInputParsingStrategy;
import com.hzitoun.xtt.parsers.impl.FileMowerAppInputParsingStrategy;
import com.hzitoun.xtt.utils.Utils;

/**
 * Tests the file parsing strategy.
 * 
 * @author hamed.zitoun
 *
 */
public class FileParsingStrategyTest {

	/**
	 * The strategy to test.
	 */
	private MowerAppInputParsingStrategy parserStrategy;
	/**
	 * A classloader used to open file from src/test/resources folder.
	 */
	private ClassLoader classLoader = getClass().getClassLoader();

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	/**
	 * Creates a new instance for each unit test to prevents potential
	 * dependency between unit tests.
	 */
	@Before
	public void setUp() {
		parserStrategy = new FileMowerAppInputParsingStrategy();
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} throw an
	 * exception when the file is missing.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testFailWhenFileNotFound() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(startsWith(Utils.getMessage("parsing.file.exception", "")));
		parserStrategy.parse("NOTEXISTING_FILE.txt");
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} can
	 * handle empty files.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testDontFailWhenFileEmpty() throws MowerAppException {
		try {
			final String file = classLoader.getResource("empty_input.txt").getFile();
			parserStrategy.parse(file);
		} catch (final MowerAppException e) {
			fail("Parser failed because file is empty!");
		}
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} throw an
	 * exception when the surface is bad formed in file.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testFailWhenSurfaceNotWellFormed() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 1)));
		final String file = classLoader.getResource("bad_input_1.txt").getFile();
		parserStrategy.parse(file);
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} throw an
	 * exception when the mower's coordinates and/or direction are bad formed in
	 * file.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testFailWhenMowerNotWellFormed() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 2)));
		final String file = classLoader.getResource("bad_input_2.txt").getFile();
		parserStrategy.parse(file);
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} throw an
	 * exception when the mower's commands are bad formed in file.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testFailWhenCommandsNotWellFormed() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 3)));
		final String file = classLoader.getResource("bad_input_3.txt").getFile();
		parserStrategy.parse(file);
	}
	
	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} throw an
	 * exception when file contains empty line.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testFailWhenFileContainsEmptyLine() throws MowerAppException {
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 2)));
		final String file = classLoader.getResource("bad_input_4.txt").getFile();
		parserStrategy.parse(file);
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} do not
	 * throw an exception when the file is well formed.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			parserStrategy.parse(file);
		} catch (final MowerAppException e) {
			fail("Shoudn't fail. Parser can't parse a well-formed file!");
		}
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} parse
	 * well the surface's height and width.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testSurfaceParsingSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			final MowerAppCharacteristics characts = parserStrategy.parse(file);
			assertNotNull(characts);
			assertNotNull(characts.getSurface());
			assertThat(characts.getSurface().getHeight(), equalTo(5));
			assertThat(characts.getSurface().getWidth(), equalTo(5));
		} catch (final MowerAppException e) {
			fail("Shoudn't fail. Parser can't parse a well-formed file!");
		}
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} parse
	 * well the mowers coordinates and orientations.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testMowerParsingSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			final MowerAppCharacteristics characts = parserStrategy.parse(file);
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
		} catch (final MowerAppException e) {
			fail("Shoudn't fail. Parser can't parse a well-formed file!");
		}
	}

	/**
	 * Asserts that {@link MowerAppInputParsingStrategy#parse(String)} parse
	 * well the mowers actions.
	 * 
	 * @throws MowerAppException
	 *             MowerAppException
	 */
	@Test
	public void testCommandsParsingSuccessWhenFileIfWellFormed() {
		try {
			final String file = classLoader.getResource("good_input.txt").getFile();
			final MowerAppCharacteristics characts = parserStrategy.parse(file);
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
		} catch (final MowerAppException e) {
			fail("Shoudn't fail. Parser can't parse a well-formed file!");
		}
	}
}
