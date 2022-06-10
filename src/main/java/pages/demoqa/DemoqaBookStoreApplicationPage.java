package pages.demoqa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DemoqaBookStoreApplicationPage {

    public static String gitPocketGuideBook = "Git Pocket Guide";

    public DemoqaBookStoreApplicationPage inputBook(String value){
        SelenideElement input = $(By.xpath("//*[@id=\"searchBox\"]")).setValue(value);
        return this;
    }

    /**
     * Searching input box, enter book name in searching box and open book page
     */
    public DemoqaBookStoreApplicationPage searchGitPocketGuideBook(){
        SelenideElement gitPocketGuideBook = $(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]"));
        gitPocketGuideBook.click();
        return this;
    }
}
