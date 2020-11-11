package com.w3w.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainMapPage extends BasePage {

    @FindBy(className = "MapGrid")
    private WebElement mapGridLayout;

    @FindBy(css = "div[class='MapGrid MapGrid_visible']")
    private WebElement mapGridSmallViewLayout;

    @FindBy(className = "ThreeWordAddress-Content")
    private WebElement searchPanel;

    @FindBy(tagName = "input")
    private WebElement searchInputTextField;

    @FindBy(css = "div[class='ThreeWordAddress-Text notranslate']")
    private WebElement searchTextField;

    @FindBy(className = "SearchPanel-Location")
    private List<WebElement> searchResultsTextList;

    @FindBy(className = "gm-svpc")
    private WebElement pegmanIcon;

    @FindBy(className = "CloseStreetView")
    private WebElement returnToFullViewLabel;

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

    public MainMapPage clickFirstSearchResult() {
        searchResultsTextList.get(0).click();
        return this;
    }

    public void waitForSearchResultsChanged(String retrievedText) {
        waitForElementTextRefreshed(searchTextField, retrievedText);
    }

    public String getSearchFieldText() {
        waitForElementToAppear(searchTextField);
        return searchTextField.getText();
    }

    public MainMapPage clickRandomPlaceOnMap() {
        clickOnElementByCoordinatesWithOffset(mapGridLayout, 50, 50);
        return this;
    }

    public MainMapPage clickMap() {
        clickWithDelay(mapGridLayout);
        return this;
    }

    public MainMapPage dragPegmanToTheScreen() {
        dragElementToTheScreen(pegmanIcon, mapGridLayout);
        return this;
    }

    public boolean isSmallViewMapVisible() {
        return mapGridSmallViewLayout.isDisplayed()
                && returnToFullViewLabel.isDisplayed();
    }

    public void clickReturnToFullScreenViewLabel(){
        clickWithDelay(returnToFullViewLabel);
    }
}
