package com.it_academy.tests.framework.driver;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverCreator<T extends RemoteWebDriver> {

    T create();
}
