package hu.masterfield.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;

public class BasketPage {
    SelenideElement basket = $(".mini-trolley__content-list");
    ElementsCollection removeItemButton = $$(".delete-single-item");

    ElementsCollection basketItems = $$(".mini-trolley__content-item");


    public void validateBasketSize(int productListSize) {
        System.out.println("Basket size: " + basketItems.size());
        assertEquals(productListSize, basketItems.size());
    }

    public void validateBasketContent(String product, String quantity) {
        String displayedQuantity = ($(By.xpath("//span[contains(text(),'" + product + "')]/preceding-sibling::span")).getText());
        System.out.println(product + " displayedQuantity: " + displayedQuantity);
        assertEquals(quantity, displayedQuantity);
    }

    public void removeItemsFromTheBasket() throws InterruptedException {

        int basketsize = removeItemButton.size()-1;

        do{
            System.out.println("remove item size: "+(removeItemButton.size()-1));
            removeItemButton.get(basketsize).shouldBe(visible).shouldBe(enabled);
            removeItemButton.get(basketsize).click();
            basketsize--;
            Thread.sleep(2000);
        }
        while(basketsize>=0);

    }
}
