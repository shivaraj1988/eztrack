package com.cg.eztrack.web.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerManager {

	static Logger log = LogManager.getLogger();

	public static void writeInfoLog(String ip, String className, String methodName, String message) {

		String str = ip + " | " + className + " | " + methodName + " | " + message;

		log.info(str);
	}

	public static void writeExceptionLog(String ip, String className, String methodName, String message,
			Exception exe) {

		String str = ip + " | " + className + " | " + methodName + " | " + message;

		log.error(str);
	}

}
