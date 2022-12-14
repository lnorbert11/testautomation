package hu.masterfield.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TescoSteps {

    public static final String TescoTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco Otthonról, Tesco Doboz Webáruház";
    public static final String HomePageUrl = "https://bevasarlas.tesco.hu/groceries";

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
        HomePage homePage = open(HomePageUrl, HomePage.class);
        String title = TescoTitle;
        homePage.validateHomePage(title);
    }

    @And("accept cookies")
    public void acceptCookies() {
        HomePage homePage = new HomePage();
        homePage.acceptCookies();
    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String lang) throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.setDesiredLanguage(lang);
    }

    //Sign in scenario
    @Then("{string} is shown")
    public void welcomeHeaderIsShown(String headerText) {
        HomePage homePage = new HomePage();
        homePage.validateWelcomeHeaderText(headerText);
        //Thread.sleep(3000);
    }

    @When("user clicks on {string} button and logs in with {string} and {string}")
    public void userClicksOnSignInButtonAndLogsIn(String signInText, String email, String password) {
        HomePage homePage = new HomePage();
        homePage.clickOnSignInButton(signInText);
        SignInPage signInPage = new SignInPage();
        signInPage.validateSignInPage();
        signInPage.signIn(email, password);
    }




    //SignOut Scenario
    @And("customer is signed in {string} with credentials {string} and {string}")
    public void customerIsSignedInWithCredentialsAnd(String signInText, String email, String password) {
        userClicksOnSignInButtonAndLogsIn(signInText, email, password);
    }

    @When("user clicks on {string} sign out button")
    public void userClicksOnSignOutButton(String signOutText) {
        HomePage homePage = new HomePage();
        homePage.clickOnSignOutButton(signOutText);
    }

    @Then("{string}  sign in link is shown")
    public void signInLinkIsShown(String signInButtonText) throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.validateSignInButton(signInButtonText);
        //Thread.sleep(3000);
    }

    //Change Language Scenario
    @When("change language to {string}")
    public void changeLanguageTo(String lang) throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.setDesiredLanguage(lang);
    }

    @Then("it shows elements in {string} with search placeholder {string}")
    public void itShowsElementsWithSearchPlaceholder(String lang, String searchPlaceHolder) {
        HomePage homePage = new HomePage();
        homePage.validateSearchBoxPlaceholder(lang, searchPlaceHolder);
    }

    //SearchBox feature
    @When("customer searches for a {string}")
    public void customerSearchesForProduct(String product) {
        HomePage homePage = new HomePage();
        homePage.setSearchBox(product);
    }

    @Then("it shows results for {string}")
    public void itShowsResultsForProductSearch(String product) {
        ResultsPage resultPage = new ResultsPage();
        resultPage.validateResultsHeadingText(product);
    }

    //open product description
    @And("customer opens product page")
    public void openProductPage() throws InterruptedException {
        ResultsPage resultsPage = new ResultsPage();
        resultsPage.openFirstResult();
        Thread.sleep(4000);
    }

    @Then("it shows {string} product description")
    public void itShowsProductDescription(String product) throws InterruptedException {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.validateProductPage(product);
        Thread.sleep(4000);
    }

    public void addProductToTheBasket(String quantity) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.addProduct(quantity);
    }

    @When("user searches for products and adding them to the basket")
    public void userSearchesForProductsAndAddingThemToTheBasket() throws InterruptedException, IOException {

        Map<String, String> quantityAndProduct = readExcelList();
        Iterator<String> iterator = quantityAndProduct.keySet().iterator();
        while (iterator.hasNext()) {
            String product = iterator.next();
            String quantity = quantityAndProduct.get(product);
            System.out.println("productName : " + product + " quantity : " + quantity);

            customerSearchesForProduct(product);
            itShowsResultsForProductSearch(product);
            openProductPage();
            itShowsProductDescription(product);
            addProductToTheBasket(quantity);

        }
    }

    @Then("products are shown in the basket")
    public void productsAreShownInTheBasket() throws IOException {
        Map<String, String> quantityAndProduct = readExcelList();

        BasketPage basketPage = new BasketPage();
        basketPage.validateBasketSize(quantityAndProduct.size());

        Iterator<String> iterator = quantityAndProduct.keySet().iterator();
        while (iterator.hasNext()) {
            String product = iterator.next();
            String quantity = quantityAndProduct.get(product);
            System.out.println("productName : " + product + " quantity : " + quantity);
            basketPage.validateBasketContent(product, quantity);
        }
    }

    @And("there are items in the basket")
    public void thereAreItemsInTheBasket() throws IOException, InterruptedException {
        userSearchesForProductsAndAddingThemToTheBasket();
        productsAreShownInTheBasket();
    }

    @When("user removes every item from the basket")
    public void userRemovesEveryItemFromTheBasket() throws InterruptedException {
        BasketPage basketPage = new BasketPage();
        basketPage.removeItemsFromTheBasket();
    }

    @Then("there is no items in the basket")
    public void thereIsNoItemsInTheBasket() {
        BasketPage basketPage = new BasketPage();
        basketPage.validateBasketSize(0);
    }

    @After //AfterStep összes lépés után
    public void cleanup() {
        System.out.println("cleanup code");
        closeWebDriver();

    }

    public Map<String, String> readExcelList() throws IOException {
        Map<String, String> quantityAndProduct = new HashMap<>();
        String quantity;
        String product;

        FileInputStream fis = new FileInputStream("productList.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            //System.out.println("product name: "+row.getCell(0)+" quantity: "+(row.getCell(1)));
            product = row.getCell(0).getStringCellValue();
            quantity = row.getCell(1).getStringCellValue();

            quantityAndProduct.put(product, quantity);
        }

        return quantityAndProduct;
    }

    @Test
    public void testExcel() throws IOException {
        System.out.println(readExcelList());

    }


}
