package in.beingzero.sandeep.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingExample {

	static Logger log = LogManager.getLogger(LoggingExample.class);
	
	public static void main(String[] args) {
		/*
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		System.out.println(df.format(new Date()));
		
		 */
		// THIS CONFIGURES A BASIC LOGGER
		// THAT LOGS ON CONSOLE
		// PUT MESSAGES IN FOLLOWING LAYOUT
		// MilliSeconds  [THREADNAME] MESSAGE_LEVEL FULL_CLASS_NAME - MESSAGE
		//BasicConfigurator.configure();
		
		
		//log.setLevel(Level.ERROR);
		
		log.debug("This is a debug message");
		log.info("This is an info message");
		log.error("This is an error message");
		
	}
	
}
