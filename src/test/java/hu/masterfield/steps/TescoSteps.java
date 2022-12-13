package hu.masterfield.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class TescoSteps {
    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = options;

        System.out.println("setup code");
    }


    @Given("open main page")
    public void openMainPage() {
        HomePage homePage = open("https://bevasarlas.tesco.hu/groceries", HomePage.class);
        String title = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco Otthonról, Tesco Doboz Webáruház";
        assertEquals(title, homePage.getTitle());
    }

    @And("accept cookies")
    public void acceptCookies()  {
        HomePage homePage = new HomePage();
        homePage.acceptCookies();
    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String lang) {
        HomePage homePage = new HomePage();
        homePage.selectLanguage(lang);

        if (lang.equals("Magyar")) {
            assertEquals("Keresés", homePage.searchBoxPlaceHolder());
        }
        if (lang.equals("English")) {
            assertEquals("Search", homePage.searchBoxPlaceHolder());
        }
    }

    //Sign in scenario
    @Then("{string} is shown")
    public void isShown(String headerText) throws InterruptedException {
        HomePage homePage = new HomePage();
        assertEquals(headerText, homePage.getWelcomeHeaderText());
        Thread.sleep(3000);
    }


    @When("user logs in with {string} and {string}")
    public void userLogsInWithAnd(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.clickOnSignInButton();
        SignInPage signInPage = new SignInPage();
        signInPage.fillSignInFormAndClickOnSignInButton(email, password);
    }

    @When("user clicks on {string} button and logs in with {string} and {string}")
    public void userClicksOnSignInButtonAndLogsIn(String signInText, String email, String password) {
        HomePage homePage = new HomePage();
        assertEquals(signInText, homePage.getTextFromSignInButton());
        homePage.clickOnSignInButton();
        SignInPage signInPage = new SignInPage();
        signInPage.fillSignInFormAndClickOnSignInButton(email, password);
    }


    @After //AfterStep összes lépés után
    public void cleanup() {
        System.out.println("cleanup code");
        closeWebDriver();

    }

    //SignOut Scenario
    @And("customer is signed in {string} with credentials {string} and {string}")
    public void customerIsSignedInWithCredentialsAnd(String signInText, String email, String password) {
        userClicksOnSignInButtonAndLogsIn(signInText, email, password);
    }

    @When("user clicks on {string} sign out button")
    public void userClicksOnSignOutButton(String signOutButtonText) {
        HomePage homePage = new HomePage();
        assertEquals(signOutButtonText, homePage.getTextFromSignOutButton());
        homePage.clickOnSignOutButton();
    }

    @Then("{string}  sign in link is shown")
    public void signInLinkIsShown(String signInButtonText) throws InterruptedException {
        HomePage homePage = new HomePage();
        assertEquals(signInButtonText, homePage.getTextFromSignInButton());
        Thread.sleep(3000);
    }


}
