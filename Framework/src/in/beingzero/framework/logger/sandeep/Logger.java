package in.beingzero.framework.logger.sandeep;

import java.util.Date;

public class Logger {

	int logLevel;
	
	public static final int DEBUG = 0;
	public static final int INFO = 1;
	public static final int ERROR = 2;
	

	private void logInternal(String msg){
		Date dt  = new Date();
		
		System.out.printf("[%s] : %s\n", dt, msg);
		//Write a line of code that puts this in a file
	}
	
	public void logDebug(String msg){
		if(logLevel<=DEBUG){
			logInternal(msg);
		}
	}
	public void logInfo(String msg){
		if(logLevel<=INFO){
			logInternal(msg);			
		}
	}
	public void logError(String msg){
		if(logLevel<=ERROR)
		{
			logInternal(msg);
		}
	}

	
	public void setLevel(int level){
		logLevel = level;
	}
}
