package com.revature.logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
public class LoggerClass {
	
	public static Logger mainLogger = (Logger) LogManager.getLogger(Logger.class.getName());
//	  public static final Logger logger = (Logger) LogManager.getLogger(Logger.class.getName());
//	  public void doIt() {
//		 
//	    logger.trace("Did it again!");
//	    
//	}
}

