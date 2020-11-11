import com.w3w.utils.Data;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("NavigationTest")
public class NavigationTest extends BaseTest {

    @Test(priority = 1, description = "Go to navigation link and check the title of the page")
    @Story("Go to navigation link and check the title of the page")
    public void navigateToLinkTest() {
        Assert.assertTrue(mainMapPage.getPageTitle().equals(Data.MAP_PAGE_TITLE), "Page title should be " + Data.MAP_PAGE_TITLE);
    }

    @Test(priority = 2, description = "Type address in search field and check result")
    @Story("Type address in search field and check result")
    public void searchDestinationTest() {
        mainMapPage.clickSearchLocation()
                .printSearchText(Data.SEARCH_DESTINATION)
                .clickFirstSearchResult()
                .waitForSearchResultsChanged(Data.SEARCH_DESTINATION);
        assertSearchFieldTextMatched(true);
    }

    @Test(priority = 3, description = "Tap random place on map, check search result changed, return to previous tile and check result")
    @Story("Tap random place on map, check search result changed, return to previous tile and check result")
    public void tapRandomPlaceOnMapAndCheckSearchResultTest() {
        mainMapPage
                .clickRandomPlaceOnMap()
                .waitForSearchResultsChanged(Data.EXPECTED_DESTINATION_IN_3WORDS);
        assertSearchFieldTextMatched(false);
        mainMapPage
                .clickMap()
                .waitForSearchResultsChanged(Data.RANDOM_LOCATION);
        assertSearchFieldTextMatched(true);
    }

    @Test(priority = 4, description = "Move prgman on the map and check map representation minimized")
    @Story("Move prgman on the map and check map representation minimized")
    public void movingPegmanAndCheckMapMinimizedTest() {
        mainMapPage
                .dragPegmanToTheScreen();
        Assert.assertTrue(mainMapPage.isSmallViewMapVisible(), "Map representation should be minimized");
        mainMapPage.clickReturnToFullScreenViewLabel();
    }

    @Step
    private void assertSearchFieldTextMatched(boolean condition) {
        Assert.assertTrue((mainMapPage.getSearchFieldText().equals(Data.EXPECTED_DESTINATION_IN_3WORDS)) == condition, "Search text field should be equal " + Data.EXPECTED_DESTINATION_IN_3WORDS
                + " but was " + mainMapPage.getSearchFieldText());
    }
}
