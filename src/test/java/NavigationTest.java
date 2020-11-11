import com.w3w.utils.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(priority = 1, description = "Go to navigation link and check the title of the page")
    public void navigateToLinkTest() {
        Assert.assertTrue(mainMapPage.getPageTitle().equals(Data.MAP_PAGE_TITLE), "Page title should be " + Data.MAP_PAGE_TITLE);
    }

    @Test(priority = 2, description = "Type address in search field and check result")
    public void searchDestinationTest() {
        mainMapPage.clickSearchLocation()
                .printSearchText(Data.SEARCH_DESTINATION)
                .clickFirstSearchResult()
                .waitForSearchResultsChanged(Data.SEARCH_DESTINATION);
        Assert.assertTrue(mainMapPage.getSearchFieldText().equals(Data.EXPECTED_DESTINATION_IN_3WORDS), "Search test field should be equal " + Data.EXPECTED_DESTINATION_IN_3WORDS
                + " but was " + mainMapPage.getSearchFieldText());
    }
}
