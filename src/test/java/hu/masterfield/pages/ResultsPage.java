package hu.masterfield.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultsPage {

    SelenideElement resultsHeading = $("#results>h1");

    SelenideElement firstItem = $(byXpath("//li[@class='product-list--list-item first']//a"));

    SelenideElement showMoreLessLink = $(".show-more-less__link>a");

    ElementsCollection displayedItems = $$(".product-list>li");

    SelenideElement itemsCount = $(".pagination__items-displayed > strong:nth-child(2)");

    public void validateResultsHeadingText(String product){
        assertTrue(resultsHeading.getText().contains(product));
    }

    public ProductDetailsPage openFirstResult(){
        firstItem.click();
        return new ProductDetailsPage();
    }

    public void setMoreLessLink(String showDisplayedItemText){
        int resultsCount = getResultsCount();

        if(resultsCount>=48)
        {
            showMoreLessLink.shouldBe(visible).shouldBe(enabled);
            if (showMoreLessLink.getText().equals(showDisplayedItemText))
            {
                showMoreLessLink.click();
            }
            showMoreLessLink.shouldNotHave((text(showDisplayedItemText)));
        }

    }

    public void validateAmountOfDisplayedItems(int expectedAmountOfDisplayedItems){
        int resultsCount = getResultsCount();

        if (expectedAmountOfDisplayedItems>=resultsCount){
            assertEquals(resultsCount,displayedItems.size());
        }else{
            assertEquals(expectedAmountOfDisplayedItems,displayedItems.size());
        }
    }

    public int getResultsCount(){
        itemsCount.shouldBe(visible);
        return Integer.valueOf(itemsCount.getText().split(" ")[0]);
    }

}
