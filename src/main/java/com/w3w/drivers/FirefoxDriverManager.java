package com.w3w.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{
    public void createDriver(){
        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
        this.webDriver = new FirefoxDriver();
    }
}
