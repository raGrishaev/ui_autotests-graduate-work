package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BusinessLocalPage {

    private final SelenideElement englishVersionButton = $(".STh9Sc .\\_GaBma > span"),
            bannerTitle = $("[data-element='bannerTitle']"),
            detailsMainText = $("[data-element='detailsMainText']");

    public BusinessLocalPage openBusinessPage() {
        open("/business/b2o/");
        return this;
    }

    public BusinessLocalPage pressEnglishVersionButton() {
        englishVersionButton.click();
        return this;
    }

    public BusinessLocalPage checkBannerTitle(String value) {
        bannerTitle.shouldHave(text(value));
        return this;
    }

    public BusinessLocalPage checkDetailsMainText(String value) {
        detailsMainText.shouldHave(text(value));
        return this;
    }

}

