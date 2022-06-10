package pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DemoqaBookPage {

    /**
     * Fields on book page to check
     */
    public static SelenideElement ISBN = $(By.xpath("//*[@id=\"ISBN-wrapper\"]/div[2]"));
    public static SelenideElement title = $(By.xpath("//*[@id=\"title-wrapper\"]/div[2]"));
    public static SelenideElement subTitle = $(By.xpath("//*[@id=\"subtitle-wrapper\"]/div[2]"));
    public static SelenideElement totalPages= $(By.xpath("//*[@id=\"pages-wrapper\"]/div[2]"));


}
