package in.beingzero.sandeep.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingExample {

	public static void main(String[] args) {
		
		// THIS CONFIGURES A BASIC LOGGER
		// THAT LOGS ON CONSOLE
		// PUT MESSAGES IN FOLLOWING LAYOUT
		// MilliSeconds  [THREADNAME] MESSAGE_LEVEL FULL_CLASS_NAME - MESSAGE
		BasicConfigurator.configure();
		
		Logger log = LogManager.getLogger(LoggingExample.class);
		
		log.setLevel(Level.INFO);;
		
		log.info("This is an info message");
		log.debug("This is a debug message");
		log.error("This is an error message");
		
	}
	
}
