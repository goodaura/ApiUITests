package pages.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.appleinsider.AppleinsiderSearchPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constants.DemoqaConstants.*;

public class DemoqaRegisterPage {

    public DemoqaRegisterPage openRegisterPage(){
        open(MAIN_PAGE + REGISTER_PAGE);
        return this;
    }

    public DemoqaRegisterPage firstNameInput(String firstName){
        SelenideElement firstNameInput = $(By.xpath("//*[@id=\"firstname\"]")).setValue(firstName);
        return this;
    }

    public DemoqaRegisterPage lastNameInput(String lastName){
        SelenideElement lastNameInput = $(By.xpath("//*[@id=\"lastname\"]")).setValue(lastName);
        return this;
    }

    public DemoqaRegisterPage userNameInput(String userName){
        SelenideElement userNameInput = $(By.xpath("//*[@id=\"userName\"]")).setValue(userName);
        return this;
    }

    public DemoqaRegisterPage passwordInput(String password){
        SelenideElement passwordInput = $(By.xpath("//*[@id=\"password\"]")).setValue(password);
        return this;
    }

    public DemoqaRegisterPage buttonRegister(){
        SelenideElement register = $(By.xpath("//*[@id=\"register\"]"));
        register.click();
        return this;
    }
    /**
     * Check error text after registration fail because of not click reCaptcha
     */
    public DemoqaRegisterPage checkErrorCaptcha(){
        SelenideElement errorCaptcha = $(By.xpath("//*[@id=\"name\"]"));
        errorCaptcha.shouldHave(Condition.text(CAPTCHA_ERROR));
        return this;
    }
}

