package pages.appleinsider;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class AppleinsiderSearchPage {
    private final ElementsCollection articleTitles = $$x("//h2//a");

    /**
     * return href from first article
     */
    public String getHrefFromFirstArticle(){
        return articleTitles.first().getAttribute("href");
    }
}
