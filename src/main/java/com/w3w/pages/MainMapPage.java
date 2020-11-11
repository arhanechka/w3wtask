package com.w3w.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMapPage extends BasePage {

    @FindBy(className = "MapGrid")
    private WebElement mapGridLayout;

    @FindBy(className = "ThreeWordAddress-Content")
    private WebElement searchPanel;

    @FindBy(tagName = "input")
    private WebElement searchInputTextField;

    @FindBy(css = "div[class='ThreeWordAddress-Text notranslate']")
    private WebElement searchTextField;

    public MainMapPage(WebDriver driver) {
        super(driver);
        init(driver);
    }

    public MainMapPage clickSearchLocation() {
        searchPanel.click();
        return this;
    }

    public MainMapPage printSearchText(String text) {
        printText(searchInputTextField, text);
        return this;
    }
}
