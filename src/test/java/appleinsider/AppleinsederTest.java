package appleinsider;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.appleinsider.AppleinsiderMainPage;
import static constants.AppleinsiderUrl.*;


public class AppleinsederTest extends BaseTest {

    @Test
    public void checkHref(){
        Assert.assertTrue(new AppleinsiderMainPage(BASE_URL)
                .search(SEARCH_STRING)
                .getHrefFromFirstArticle()
                .contains(EXPECTED_WORD));
    }

    @Test
    public void previousIsNotVisible() {
        new AppleinsiderMainPage(BASE_URL)
                .checkPreviousIsNotVisible();

    }
    @Test
    public void previousIsVisible() {
        new AppleinsiderMainPage(BASE_URL)
                .checkPreviousIsVisible();
    }
}
