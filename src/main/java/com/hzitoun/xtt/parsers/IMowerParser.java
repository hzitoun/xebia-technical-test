package com.hzitoun.xtt.parsers;

import com.hzitoun.xtt.app.MowerAppCharacteristics;
import com.hzitoun.xtt.exceptions.MowerAppException;

public interface IMowerParser {
	MowerAppCharacteristics parse(String filePath) throws MowerAppException;
}
