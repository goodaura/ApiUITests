package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    /**
    * Selenide initialization with settings
    */
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.startMaximized = true;

    }

    /**
     * Initialize WebDriver before each test run
     */
    @Before
    public void init(){

        setUp();
    }

    /**
     * Closing the browser after each test
     */
    @After
    public void tearDown(){

        Selenide.closeWebDriver();
    }
}