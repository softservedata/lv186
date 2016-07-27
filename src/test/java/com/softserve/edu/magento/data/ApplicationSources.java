package com.softserve.edu.magento.data;

interface IUpdateApplicationSources {
    void setProperty(ApplicationSources applicationSources, String propertyText);    
}

public class ApplicationSources {

    static class BrowserName implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setBrowserName(propertyText);
        }
    }

    static class DriverPath implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setDriverPath(propertyText);
        }
    }
 
    static class ImplicitTimeOut implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setImplicitTimeOut(Long.valueOf(propertyText));
        }
    }
 
    static class ExplicitTimeOut implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setExplicitTimeOut(Long.valueOf(propertyText));
        }
    }

    static class SearchStrategy implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setSearchStrategy(propertyText);
        }
    }

    static class LoadUrl implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setLoadUrl(propertyText);
        }
    }

    static class LogoutUrl implements IUpdateApplicationSources {
        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            //ApplicationSources.this.setBrowserName(propertyText);
            applicationSources.setLogoutUrl(propertyText);
        }
    }
    
    public static enum ApplicationSourcesFields {
        BROWSER_NAME(new BrowserName(), "browserName"),
        DRIVER_PATH(new DriverPath(), "driverPath"),
        IMPLICIT_TIMEOUT(new ImplicitTimeOut(), "implicitTimeOut"),
        EXPLICIT_TIMEOUT(new ExplicitTimeOut(), "explicitTimeOut"),
        SEARCH_STRATEGY(new ExplicitTimeOut(), "searchStrategy"),
        LOAD_URL(new LoadUrl(), "loadUrl"),
        LOGOUT_URL(new LogoutUrl(), "logoutUrl");
        private IUpdateApplicationSources updateApplicationSources;
        private String propertyName;

        private ApplicationSourcesFields(IUpdateApplicationSources updateApplicationSources, String propertyName) {
            this.updateApplicationSources = updateApplicationSources;
            this.propertyName = propertyName;
        }

        public void setProperty(ApplicationSources applicationSources, String propertyText) {
            updateApplicationSources.setProperty(applicationSources, propertyText);
        }

        @Override
        public String toString() {
            return propertyName;
        }
    }

    // Browser Data
    private String browserName;
    private String driverPath;
    // private String browserPath;
    // private String defaulProfile;
    // private String[] browserParameters;
    //
    // Implicit and Explicit Waits
    private long implicitTimeOut;
    private long explicitTimeOut;
    //private long pageLoadTimeout;
    //private long scriptTimeout;
    //
    // Search Strategy
    private String searchStrategy;
    //
    // Localization Strategy
    // private String language;
    //
    // Logger Strategy
    // private String loggerStrategy;
    //
    // URLs
    private String loadUrl;
    private String logoutUrl;
    //
    // private String serverUrl;
    // private String serverPort;
    // private String serverUri;
    //
    // Connect to DB
    
    // Constructor
    // TODO Develop Fluent interface, Builder
    public ApplicationSources(String browserName, String driverPath,
            long implicitTimeOut, long explicitTimeOut, String searchStrategy, 
            String loadUrl, String logoutUrl) {
        this.browserName = browserName;
        this.driverPath = driverPath;
        this.implicitTimeOut = implicitTimeOut;
        this.explicitTimeOut = explicitTimeOut;
        this.searchStrategy = searchStrategy;
        this.loadUrl = loadUrl;
        this.logoutUrl = logoutUrl;
    }

    // TODO clone
    
    // getters
    
    public String getBrowserName() {
        return browserName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public long getImplicitTimeOut() {
        return implicitTimeOut;
    }

    public long getExplicitTimeOut() {
        return explicitTimeOut;
    }

    public String getSearchStrategy() {
        return searchStrategy;
    }

    public String getLoadUrl() {
        return loadUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    // setters
    
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public void setImplicitTimeOut(long implicitTimeOut) {
        this.implicitTimeOut = implicitTimeOut;
    }

    public void setExplicitTimeOut(long explicitTimeOut) {
        this.explicitTimeOut = explicitTimeOut;
    }

    public void setSearchStrategy(String searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void setLoadUrl(String loadUrl) {
        this.loadUrl = loadUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

}
