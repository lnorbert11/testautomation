package hu.masterfield.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ProductDetailsPage {

    SelenideElement productHeader = $(".product-details-tile__title");

    SelenideElement addButton = $(".controls>div>button");

    SelenideElement productInputTextBox = $(".product-input");

    public void validateProductPage(String product){
        assertTrue(productHeader.getText().contains(product));
    }

    public void addProduct(String quantity){
        productInputTextBox.shouldBe(visible).shouldBe(enabled);
        productInputTextBox.sendKeys(Keys.BACK_SPACE);
        productInputTextBox.sendKeys(quantity);
        addButton.shouldBe(visible).shouldBe(enabled);
        addButton.click();
    }

}
