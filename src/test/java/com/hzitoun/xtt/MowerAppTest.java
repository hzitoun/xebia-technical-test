package com.hzitoun.xtt;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.hzitoun.xtt.app.MowerApp;
import com.hzitoun.xtt.app.MowerAppFactory;
import com.hzitoun.xtt.exceptions.MowerAppException;
import com.hzitoun.xtt.parsers.MowerAppInputParsingStrategy;
import com.hzitoun.xtt.parsers.impl.FileMowerAppInputParsingStrategy;
import com.hzitoun.xtt.utils.Utils;

public class MowerAppTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	

	@Test
	public void testStartWithoutSettingStrategy() throws MowerAppException {
		final MowerApp app = MowerAppFactory.createApp();
		final ClassLoader classLoader = getClass().getClassLoader();
		final String file = classLoader.getResource("good_input.txt").getFile();
		app.setParsingStrategy(null);
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.strategy.undefined")));
		app.start(file);
	}

	@Test
	public void testStartWhenFileIsNotWellFormed() throws MowerAppException {
		final MowerApp app = MowerAppFactory.createApp();
		final ClassLoader classLoader = getClass().getClassLoader();
		final String file = classLoader.getResource("bad_input_1.txt").getFile();
		final MowerAppInputParsingStrategy strategy = new FileMowerAppInputParsingStrategy();
		exception.expect(MowerAppException.class);
		exception.expectMessage(equalTo(Utils.getMessage("parsing.line.error", 1)));
		app.setParsingStrategy(strategy);
		app.start(file);
	}

	@Test
	public void testStartWhenFileIsWellFormed() throws UnsupportedEncodingException {
		final MowerApp app = MowerAppFactory.createApp();
		final ClassLoader classLoader = getClass().getClassLoader();
		final String file = classLoader.getResource("good_input_2.txt").getFile();
		final MowerAppInputParsingStrategy strategy = new FileMowerAppInputParsingStrategy();
		app.setParsingStrategy(strategy);
	    try {
			app.start(file);
		} catch (final MowerAppException e) {
			fail("Exception should be thrown since file is well formed!");
		}
	}
}
