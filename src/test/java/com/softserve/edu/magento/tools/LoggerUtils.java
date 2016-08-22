package com.softserve.edu.magento.tools;

public class LoggerUtils {
    private static volatile LoggerUtils instance = null;
    private ILogger logger;

    private LoggerUtils() {
    }

    public static LoggerUtils get() {
        if (instance == null) {
            synchronized (LoggerUtils.class) {
                if (instance == null) {
                    instance = new LoggerUtils();
                    instance.setLog4JStrategy();
                }
            }
        }
        return instance;
    }

    public ILogger getLogger() {
		return this.logger;
	}

    // Set Strategy.
    public LoggerUtils setLogger(ILogger logger) {
        synchronized (LoggerUtils.class) {
            this.logger = logger;
        }
        return this;
    }

    public LoggerUtils setLog4JStrategy() {
        return setLogger(Log4jWrapper.get());
    }

    public void errorLog(String message) {
        // TODO getClass, getMethod
        this.logger.error(message);
    }

    public void warningLog(String message) {
        // TODO getClass, getMethod
        this.logger.warning(message);
    }

    public void infoLog(String message) {
        // TODO getClass, getMethod
        this.logger.info(message);
    }

    //public void debugLog(String message) {}
    
    public void insertPathToScreenShot(String fileNamePath) {
        this.logger.insertPathToScreenShot(fileNamePath);
    }

    // TODO
    //void insertPathToHtmlCode(String fileNamePath) {}
    
}
