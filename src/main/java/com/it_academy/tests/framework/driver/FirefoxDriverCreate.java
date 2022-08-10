package com.it_academy.tests.framework.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverCreate implements WebDriverCreator{
    @Override
    public RemoteWebDriver create() {
        return new FirefoxDriver();
    }
}
