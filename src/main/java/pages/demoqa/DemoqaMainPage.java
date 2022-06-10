package pages.demoqa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.appleinsider.AppleinsiderSearchPage;

import static com.codeborne.selenide.Selenide.$;
/**
 * Main page of https://demoqa.com/
 */

public class DemoqaMainPage {

    public DemoqaMainPage(String url){
        Selenide.open(url);
    }
    public static SelenideElement booksStoreApplications = $(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));

    /**
     * Searching Book store application page and open it
     */
    public DemoqaBookStoreApplicationPage openBookStoreApplication (){
        booksStoreApplications.click();
        return new DemoqaBookStoreApplicationPage();
    }

}
