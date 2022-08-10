package com.it_academy.tests.framework.driver;

import com.applitools.eyes.exceptions.NotSupportedException;

public class DriverCreatorFactory {
    public DriverCreatorFactory() {
    }

    public static WebDriverCreator getDriverCreator(String driverType) {
         switch (driverType) {
            case "chrome" :
                return new ChromeDriverCreator();
            case "firefox" :
                return new FirefoxDriverCreate();
             default:
                 throw new NotSupportedException(driverType + "is not supported by the software");
        }
    }
}
