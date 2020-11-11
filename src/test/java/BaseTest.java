import com.w3w.drivers.DriverManager;
import com.w3w.drivers.DriverManagerFactory;
import com.w3w.drivers.DriverTypes;
import com.w3w.pages.MainMapPage;
import com.w3w.utils.Data;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static DriverManager driverManager;
    static MainMapPage mainMapPage;
    static String browser;

    @BeforeClass
    public static void setUp() {
        browser = System.getProperty("driver") != null ? System.getProperty("driver") : "CHROME";
        driverManager = DriverManagerFactory.getDriver(DriverTypes.valueOf(browser));
        driverManager.getDriver().get(Data.URL);
        driverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initPages();
    }

    protected static void initPages(){
        mainMapPage = new MainMapPage(driverManager.getDriver());
    }

    @AfterClass
    public static void tearDown(){
        driverManager.quitDriver();
    }
}
