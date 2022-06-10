package demoqa;

import base.BaseTest;
import org.junit.Test;
import pages.demoqa.DemoqaMainPage;
import pages.demoqa.DemoqaRegisterPage;

import static constants.DemoqaConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.demoqa.DemoqaBookPage.*;
import static pages.demoqa.DemoqaBookStoreApplicationPage.gitPocketGuideBook;



public class DemoqaTest extends BaseTest {

    @Test
    public void FindBookAndCheckFieldsTest() {

        new DemoqaMainPage(MAIN_PAGE)
                .openBookStoreApplication()
                .inputBook(gitPocketGuideBook)
                .searchGitPocketGuideBook();
        assertEquals(GIT_POCKET_GUIDE_ISBN, ISBN.getText());
        assertEquals(GIT_POCKET_GUIDE_TITLE, title.getText());
        assertEquals(GIT_POCKET_GUIDE_SUB_TITLE, subTitle.getText());
        assertEquals(GIT_POCKET_GUIDE_TOTAL_PAGES, totalPages.getText());
    }

    @Test
    public void CaptchaErrorTest(){

        DemoqaRegisterPage registerPage = new  DemoqaRegisterPage();

        registerPage.openRegisterPage()
                .firstNameInput(FIRST_NAME)
                .lastNameInput(LAST_NAME)
                .userNameInput(USER_NAME)
                .passwordInput(PASSWORD)
                .buttonRegister()
                .checkErrorCaptcha();
    }
}
