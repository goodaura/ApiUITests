package pages.appleinsider;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Main page of https://appleinsider.ru/
 */
public class AppleinsiderMainPage {
    public final SelenideElement textBoxInput = $x("//input[@type='text']");
    public final SelenideElement previousButton
            =$(By.xpath("//span[@class='pagination-text' and text()='Предыдущая']"));
    public final SelenideElement nextButton
            =$(By.xpath("//span[@class='pagination-text' and text()='Следующая']"));


    public AppleinsiderMainPage(String url){
        Selenide.open(url);
    }

    /**
     * Searching article and Enter
     * @param searchString text in search string
     */
    public SearchPage search(String searchString){
        textBoxInput.setValue(searchString);
        textBoxInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

    /**
     * Searching for button "Previous" and check it's not visible
     */
    public AppleinsiderMainPage checkPreviousIsNotVisible(){
        previousButton.shouldNotBe(visible);
        return this;
    }

    /**
     * Searching for button "Previous" and check it's visible
     */
    public AppleinsiderMainPage checkPreviousIsVisible(){
        nextButton.click();
        previousButton.shouldBe(visible);
        return this;
    }
}


