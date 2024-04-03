package Logging;

import org.apache.logging.log4j.*;

public class LoggerDemo {

	public static void main(String[] args) {
		/*Logging means some way to indicate the state of the system at runtime.
		The log message have to provide the required information to understand
		what the application does internally during runtime. (record of operation/output stored/maintain in log file)
		Log4j -> logging framework
		if we want to debug/analyze output or check the behavior of input/output after execution of code -> logging
		Logging file Location -> src/main/resource -> log4j2.xml
		https://logging.apache.org/log4j/2.x/manual/customloglevels.html*/

		//create object of logger
		Logger log = LogManager.getLogger("LoggerDemo");
		System.out.println("Logger Demo");
		log.info("for info only");
		log.debug("debug message");
		log.warn("warning message");

	}

}
