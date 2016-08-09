package com.softserve.edu.magento.tools;

import java.util.HashMap;

import org.testng.ITestContext;

import com.softserve.edu.magento.data.ApplicationSources;
import com.softserve.edu.magento.data.ApplicationSources.ApplicationSourcesFields;

public class ParameterUtils {
	private static volatile ParameterUtils instance = null;
	//
	private static final String SUREFIRE_WEBDRIVER_NAME = "surefire.webdriver.name";
    private static final String SUREFIRE_WEBDRIVER_DRIVERPATH = "surefire.webdriver.driverpath";
    private static final String DEFAULT_POM_FROM = "from";
    private static final String DEFAULT_POM_CODE = "code";
    //
    private boolean isCIRunnig = false;

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
		instance.isCIRunnig = false;
		return instance;
	}

    public ApplicationSources updateParametersFromPOM(ApplicationSources applicationSources) {
        if ((System.getProperty(SUREFIRE_WEBDRIVER_NAME) != null)
                && (System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH) != null)
                && (!System.getProperty(SUREFIRE_WEBDRIVER_NAME).toLowerCase().contains(DEFAULT_POM_FROM))
                && (!System.getProperty(SUREFIRE_WEBDRIVER_NAME).toLowerCase().contains(DEFAULT_POM_CODE))) {
            applicationSources.setBrowserName(System.getProperty(SUREFIRE_WEBDRIVER_NAME));
            applicationSources.setDriverPath(System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH));
            isCIRunnig = true;
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
        }
        return applicationSources;
    }

    // TODO and add clone in ApplicationSources
    //public List<ApplicationSources> updateBrowsersFromTestNGxml(ApplicationSources applicationSources, ITestContext context) {}
    //
//    public List<ApplicationSources> updateParametersFromTestNGxml(List<ApplicationSources> applicationSources, ITestContext context) {
//        return null;
//    }

    public ApplicationSources updateParametersAll(ApplicationSources applicationSources, ITestContext context) {
        applicationSources = updateParametersFromPOM(applicationSources);
        if (!isCIRunnig) {
            applicationSources = updateParametersFromTestNGxml(applicationSources, context);
        }
      return applicationSources;  
    }
    
//    public List<ApplicationSources> updateParameters(List<ApplicationSources> applicationSources, ITestContext context) {
//        return null;  
//     }

}
