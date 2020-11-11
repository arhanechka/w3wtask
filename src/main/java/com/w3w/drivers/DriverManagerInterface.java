package com.w3w.drivers;

import org.openqa.selenium.WebDriver;

public interface DriverManagerInterface {
    public void createDriver();
    public WebDriver getDriver();
    public void quitDriver();
}
