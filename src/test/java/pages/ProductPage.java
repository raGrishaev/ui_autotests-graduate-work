package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    private final SelenideElement
            addToBasketButton = $x("//button[contains(.,'В корзину')]"),
            basketButton = $(".srcmPl");

    public ProductPage openProductPage() {
        open("/shop/details/programmnoe-obespechenie-" +
                "kaspersky-cloud-password-manager-1-god-1-ustroistvo/");
        return this;
    }

    public ProductPage addToBasket() {
        addToBasketButton.click();
        return this;
    }

    public ProductPage goToBasket() {
        basketButton.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }


}
