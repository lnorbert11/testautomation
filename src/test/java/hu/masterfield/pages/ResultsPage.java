package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ResultsPage {

    SelenideElement resultsHeading = $("#results>h1");

    SelenideElement firstItem = $(byXpath("//li[@class='product-list--list-item first']//a"));

    public void validateResultsHeadingText(String product){
        assertTrue(resultsHeading.getText().contains(product));
    }

    public ProductDetailsPage openFirstResult(){
        firstItem.click();
        return new ProductDetailsPage();
    }

}
