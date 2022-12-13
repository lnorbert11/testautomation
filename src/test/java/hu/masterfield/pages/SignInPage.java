package hu.masterfield.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    SelenideElement emailTextBox = $(Selectors.byId("email"));
    SelenideElement passwordTextBox = $(Selectors.byId("password"));
    SelenideElement signInButton = $(Selectors.byAttribute("type","submit"));

    public void fillSignInFormAndClickOnSignInButton(String email,String password)  {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

}
