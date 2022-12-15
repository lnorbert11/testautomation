package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    SelenideElement emailTextBox = $("#email");
    SelenideElement passwordTextBox = $("#password");
    SelenideElement signInButton = $(byAttribute("type","submit"));

    //SelenideElement signInTitle = $(byTagName("title"));

    public void validateSignInPage(){
        emailTextBox.shouldBe(visible).shouldBe(enabled);
        passwordTextBox.shouldBe(visible).shouldBe(enabled);
        signInButton.shouldBe(visible).shouldBe(enabled);
    }

    public HomePage signIn(String email, String password)  {


/*
        WebDriver driver = WebDriverRunner.getWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('email').setAttribute('value', 'gipsz.jakab@noreply.com')");

 */
        emailTextBox.setValue(email);
        passwordTextBox.setValue(password);
        signInButton.click();
        return new HomePage();
    }

}
