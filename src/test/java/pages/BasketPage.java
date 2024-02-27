package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private final SelenideElement
            productTitle = $(".sOq1u"),
            productQuantity = $(".pVCRw"),
            productPrice = $(".mR8rM"),
            deleteButton = $(".UcWhC"),
            removalInfo = $(".Z5sL5");

    public BasketPage verifyProductTitle(String value) {
        productTitle.shouldHave(text(value));
        return this;
    }

    public BasketPage verifyProductQuantity(String value) {
        productQuantity.shouldHave(text(value));
        return this;
    }

    public BasketPage verifyProductPrice(String value) {
        productPrice.shouldHave(text(value));
        return this;
    }

    public BasketPage deleteProduct() {
        deleteButton.click();
        return this;
    }

    public BasketPage verifyRemovalInfo(String value) {
        removalInfo.shouldHave(text(value));
        return this;
    }

}