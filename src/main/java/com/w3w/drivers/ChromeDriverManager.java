package com.w3w.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
    public void createDriver(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        options.addArguments("start-maximized");
        this.webDriver = new ChromeDriver(options);
    }
}
