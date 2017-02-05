package in.beingzero.tests.sandeep;

import org.testng.annotations.Test;

import in.beingzero.framework.logger.sandeep.Logger;


public class TestWithLogging {

	@Test
	public void test(){
		
		Logger log = new Logger();
		
		log.setLevel(Logger.INFO);
		
		//Logger.DEBUG = 4;
		
		log.logInfo("INFO MESSAGE FROM TEST");
		log.logError("ERROR MESSAGE FROM TEST");
		log.logDebug("DEBUG MESSAGE FROM TEST");
	}
	
}
