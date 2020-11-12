import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTests extends BaseTest {

    @DataProvider(name = "searchStrings")
    public Object[][] dataProviderMethod() {
        return new Object[][] { {"into.helps.ledge"}, {"scramble.gaps.cobbled"} };
    }

    @BeforeClass
    public void clickOnSearchField(){
        mainMapPage
                .clickSearchLocation();
    }

    @Test(dataProvider = "searchStrings")
    @Story("Search for w3w string and check words uniqueness")
    @Parameters({"searchString"})
    public void checkWordsUniquenessTest(String searchString) {
        mainMapPage
                .printSearchText(searchString);
        checkTextResultsUniqueness();
        checkAddressResultsUniqueness();
    }

    @Test
    @Story("Search for wrong w3w string and check words suggestions")
    public void searchThreeWordsSuggestionFotWrongWordsTest() {
        mainMapPage
                .printSearchText("goood.place.live");
        checkSearchResultsSize();
        checkTextResultsUniqueness();
        checkAddressResultsUniqueness();
    }

    @Step
    private void checkTextResultsUniqueness(){
        Assert.assertTrue(mainMapPage.isSearchResultUnique(), "Search results data should be unique");
    }

    @Step
    private void checkAddressResultsUniqueness(){
        Assert.assertTrue(mainMapPage.isSearchAddressesResultUnique(), "Addresses results data should be unique");
    }

    @Step
    private void checkSearchResultsSize(){
        Assert.assertTrue(mainMapPage.checkSearchResultsSizeEqualsThree(), "Search results size should have correct length");
    }

    @AfterMethod
    public void closeSearch() {
        mainMapPage.clickCloseSearch();
    }
}
