package com.w3w.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final int TIMEOUT = 10;
    private static final int POLLING = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return  driver.getTitle();
    }

    protected void printText(WebElement element, String text){
        element.click();
        element.sendKeys(text);
    }
}
