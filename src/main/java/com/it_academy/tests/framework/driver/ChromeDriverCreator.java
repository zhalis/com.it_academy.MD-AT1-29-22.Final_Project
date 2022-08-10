package com.it_academy.tests.framework.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator implements WebDriverCreator{
    @Override
    public RemoteWebDriver create() {
        return new ChromeDriver();
    }
}
