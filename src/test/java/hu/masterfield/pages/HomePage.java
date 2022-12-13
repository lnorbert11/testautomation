package hu.masterfield.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    SelenideElement signInButton = $(Selectors.byId("utility-header-login-link"));
    SelenideElement acceptCookiesButton = $(Selectors.byXpath("//form[@class='beans-cookies-notification__form'][1]//button"));

    SelenideElement languageSelector = $(Selectors.byCssSelector("#utility-header-language-switch-link>span>span"));

    SelenideElement searchBox = $(Selectors.byId("search-input"));

    SelenideElement welcomeHeader = $(Selectors.byId("utility-header-greetings"));

    SelenideElement signOutButton = $(By.id("utility-header-logout-link"));

    public void acceptCookies(){
        acceptCookiesButton.click();
    }

    public void selectLanguage(String lang){
        if (languageSelector.getText().equals(lang)){
            languageSelector.click();
        }
    }

    public String searchBoxPlaceHolder(){
        return searchBox.getAttribute("placeholder");
    }

    public String getTitle(){
        return Selenide.title();
    }
    public SignInPage clickOnSignInButton(){
        signInButton.click();
        return new SignInPage();
    }

    public String getTextFromSignOutButton(){
        return signOutButton.getText();
    }

    public String getTextFromSignInButton(){
        return signInButton.getText();
    }

    public void clickOnSignOutButton(){
        signOutButton.click();
    }

    public String getWelcomeHeaderText(){
        return welcomeHeader.getText();
    }

}
