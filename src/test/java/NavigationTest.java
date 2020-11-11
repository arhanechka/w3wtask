import com.w3w.utils.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest{

    @Test
    public void navigateToLinkTest(){
        Assert.assertTrue(mainMapPage.getPageTitle().equals(Data.MAP_PAGE_TITLE), "Page title should be " + Data.MAP_PAGE_TITLE);
    }
}
