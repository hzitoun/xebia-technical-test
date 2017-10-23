package com.hzitoun.xtt;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hzitoun.xtt.app.MowerApp;
import com.hzitoun.xtt.app.MowerAppFactory;

public class MowerAppFactoryTest {

	@Test
	public void testCreateMethodReturnsOnlyOneInstance() {
		final MowerApp app = MowerAppFactory.createApp();
		assertNotNull(app);
		assertThat(app, equalTo(MowerAppFactory.createApp()));
		assertTrue(app == MowerAppFactory.createApp());
	}
}
