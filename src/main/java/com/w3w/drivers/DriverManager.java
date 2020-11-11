package com.w3w.drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager implements DriverManagerInterface{
    protected WebDriver webDriver;
    public abstract void createDriver();

    public WebDriver getDriver(){
        if (webDriver==null)
            createDriver();
        return webDriver;
    }

    public void quitDriver(){
        if (webDriver!=null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
