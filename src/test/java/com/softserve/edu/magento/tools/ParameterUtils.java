package com.softserve.edu.magento.tools;

import java.util.HashMap;

import org.testng.ITestContext;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSources.ApplicationSourcesFields;

public class ParameterUtils {
	private static volatile ParameterUtils instance = null;
	//
	private static final String SUREFIRE_WEBDRIVER_NAME = "surefire.webdriver.name";
    private static final String DEFAULT_POM_FROM = "from";
    private static final String DEFAULT_POM_CODE = "code";

	private ParameterUtils() {
	}

	public static ParameterUtils get() {
		if (instance == null) {
			synchronized (ParameterUtils.class) {
				if (instance == null) {
					instance = new ParameterUtils();
				}
			}
		}
		return instance;
	}

    public ApplicationSources updateParametersFromPOM(ApplicationSources applicationSources) {
        if ((System.getProperty(SUREFIRE_WEBDRIVER_NAME) != null)
                && (!System.getProperty(SUREFIRE_WEBDRIVER_NAME).toLowerCase().contains(DEFAULT_POM_FROM))
                && (!System.getProperty(SUREFIRE_WEBDRIVER_NAME).toLowerCase().contains(DEFAULT_POM_CODE))) {
            applicationSources.setBrowserName(System.getProperty(SUREFIRE_WEBDRIVER_NAME));
        }
        return applicationSources;
    }

    public ApplicationSources updateParametersFromTestNGxml(ApplicationSources applicationSources, ITestContext context) {
        HashMap<String, String> allParameters = new HashMap<String, String>(
                context.getCurrentXmlTest().getAllParameters());
        for (String key : allParameters.keySet()) {
            //System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
            for (ApplicationSourcesFields applicationSourcesFields : ApplicationSourcesFields.values()) {
                if (key.toLowerCase().contains(applicationSourcesFields.toString().toLowerCase())) {
                    applicationSourcesFields.setProperty(applicationSources,
                            allParameters.get(key));
                    break;
                }
            }
            browser = getBrowserByString(allParameters.get(key));
            if (browser != null) {
                browsers.add(browser);
            }
        }
        return applicationSources;
    }
    
	public ApplicationSources updateApplicationSources(ApplicationSources applicationSources, ITestContext context) {
		if (context != null) {
	        HashMap<String, String> testParameters = new HashMap<String, String>(context.getCurrentXmlTest().getAllParameters());
	        for (String key : testParameters.keySet()) {
	        	System.out.println("Test parameter: key=" + key + " value=" + testParameters.get(key));
	        	if (key.toLowerCase().equals("browsername")) {
	        		applicationSources.setBrowserName(testParameters.get(key));
	        		continue;
	        	} else if (key.toLowerCase().equals("driverpath")) {
	        		applicationSources.setDriverPath(testParameters.get(key));
	        		continue;
	        	} else if (key.toLowerCase().equals("loginurl")) {
	        		applicationSources.setLoginUrl(testParameters.get(key));
	        		continue;
	        	} else if (key.toLowerCase().equals("logouturl")) {
	        		applicationSources.setLogoutUrl(testParameters.get(key));
	        		continue;
	        	}
	        }
		}
		return applicationSources;
	}
}
