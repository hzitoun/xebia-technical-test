package com.hzitoun.xtt.app;

/**
 * Mower app's factory. The aim of using this factory to create a unique
 * instance of mower app.
 * 
 * @author hamed.zitoun
 *
 */
public class MowerAppFactory {

	/**
	 * Mower app's instance.
	 */
	private static MowerApp instance;

	/**
	 * Private constructor to prevent instance creation.
	 */
	private MowerAppFactory() {
	}

	/**
	 * @return instance of MowerApp.
	 */
	public static MowerApp createApp() {
		if (null == instance) {
			instance = new MowerApp();
		}
		return instance;
	}

}
