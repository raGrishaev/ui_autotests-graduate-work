package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ShopSearchPage {

    private final SelenideElement
            searchField = $("#search_open_modal"),
            closeButtonLocalTable = $(".eZEtAz");

    private final ElementsCollection
            searchResultsList = $$("div[data-index-search]");

    public ShopSearchPage openShopPage() {
        open("/shop/");
        return this;
    }

    public ShopSearchPage closeTableLocal() {
        if (closeButtonLocalTable.isDisplayed()) {
            closeButtonLocalTable.click();
        }
        return this;
    }

    public ShopSearchPage clickSearchField() {
        searchField.shouldBe(Condition.visible).click();
        return this;
    }

    public ShopSearchPage enterSearchQuery(String value) {
        searchField.setValue(value);
        return this;
    }

    public ShopSearchPage initiateSearch() {
        searchField.pressEnter();
        return this;
    }

    public ShopSearchPage verifySearchResults(String expectedQuery) {
        searchResultsList.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : searchResultsList.filter(Condition.text(expectedQuery))) {
            element.shouldBe(Condition.visible);
        }
        return this;
    }

}

