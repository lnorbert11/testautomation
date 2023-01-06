package hu.masterfield.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.layout.TestDevice;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HomePage {
    SelenideElement signInButton = $("#utility-header-login-link");
    //SelenideElement acceptCookiesButton = $(Selectors.byXpath("//form[@class='beans-cookies-notification__form'][1]//button"));
    SelenideElement acceptCookiesButton = $(".beans-cookies-notification__form:nth-child(1)");

    SelenideElement languageSelector = $("#utility-header-language-switch-link>span>span");

    SelenideElement searchBox = $("#search-input");

    SelenideElement welcomeHeader = $("#utility-header-greetings");

    SelenideElement signOutButton = $("#utility-header-logout-link");

    SelenideElement searchButton = $("#search-form>button");

    public void acceptCookies(){
        acceptCookiesButton.click();
    }

    public void setDesiredLanguage(String lang){
        languageSelector.shouldBe(visible).shouldBe(enabled);
        if (lang.equals(languageSelector.getText())){
            languageSelector.click();
        }
        assertNotEquals(lang,languageSelector.getText());
    }

    public void validateHomePage(String title){
        assertEquals(title,Selenide.title());
    }

    public SignInPage clickOnSignInButton(String signInText){
        validateSignInButton(signInText);
        signInButton.click();
        return new SignInPage();
    }
    public void validateSignInButton(String signInText){
        signInButton.shouldBe(visible).shouldBe(enabled);
        assertEquals(signInText,signInButton.getText());
    }

    public void clickOnSignOutButton(String signOutText){
        validateSignOutButton(signOutText);
        signOutButton.click();
    }
    public void validateSignOutButton(String signOutText){
        signOutButton.shouldBe(visible).shouldBe(enabled);
        assertEquals(signOutText,signOutButton.getText());
    }

    public void validateWelcomeHeaderText(String headerText){
        assertEquals(headerText,welcomeHeader.getText());
    }

    public void validateSearchBoxPlaceholder(String lang,String searchPlaceHolder){
        assertNotEquals(lang,languageSelector.getText());
        assertEquals(searchPlaceHolder,searchBox.getAttribute("placeholder"));
    }

    public ResultsPage setSearchBox(String product){
        searchBox.sendKeys(product);
        System.out.println(searchButton.getText());

        searchButton.click();
        return new ResultsPage();
    }

    public LayoutReport validateHomePageWithGalen(WebDriver driver,TestDevice device) throws IOException {
        //WebDriver driver = WebDriverRunner.getWebDriver();
        LayoutReport layoutReport = Galen.checkLayout(driver,"specs/productsLayout.gspec",device.getTags());
        return layoutReport;
    }

}
