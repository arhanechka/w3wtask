package com.w3w.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementTextRefreshed(WebElement element, String retrievedText) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element,retrievedText)));
    }

    protected void clickOnElementByCoordinatesWithOffset(WebElement element, int xOffset, int yOffset){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).moveByOffset(xOffset, yOffset).click().perform();
    }

    protected void clickWithDelay(WebElement element){
        try{
            Thread.sleep(1000);
            element.click();
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    protected void dragElementToTheScreen(WebElement draggable, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, target).dragAndDrop(draggable, target).build().perform();
    }
}
