package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ServicesPage {

    private final SelenideElement
            phoneTab = $x("//span[contains(text(),'Телефон')]"),
            internetTab = $x("//span[contains(text(),'Интернет')]"),
            phoneInput = $("[placeholder='+7 000 000 00 00']"),
            internetAccountInput = $("[placeholder='080 000 00 00']"),
            sumInput = $("[placeholder='100–15000 ₽ без комиссии']"),
            sbpMethodButton = $(".iOcoc1"),
            sbpMethodListContainer = $(".NGG6H1"),
            paymentButton = $(".aLxInI"),
            sbpPaymentOutput = $(".Rtwc5X"),
            sumOutput = $(".QzDudi"),
            internet100mbButton = $("ul.cU9N1v.ZyZmxk li:nth-child(1) button.C98SUL"),
            internet500mbButton = $("ul.cU9N1v.ZyZmxk li:nth-child(2) button.oICgm7"),
            internet600mbButton = $("ul.cU9N1v.ZyZmxk li:nth-child(3) button.kpGzEV"),
            streetInput = $("[placeholder='Улица']"),
            houseInput = $("[placeholder='Дом']"),
            flatsInput = $("[placeholder='Квартира']"),
            connectionButton = $(".KsBhqU .OJcgFt"),
            phoneNumberInput = $("input[name='phone']"),
            userApplicationButton = $(".UQhmQl .OJcgFt"),
            applicationAcceptedMessage = $(".Hm0bBJ .gNtv_P"),
            emailInput = $("[placeholder='Напишите свой e-mail']"),
            subscriptionButton = $(".E8mhE"),
            subscriptionOutput = $(".YN0hl");

    ElementsCollection adressList = $$(".s5mFaC .KtOkRS");

    public ServicesPage openServicesPage() {
        open("/customers/products/");
        return this;
    }

    public ServicesPage clickPhoneTab() {
        phoneTab.click();
        return this;
    }

    public ServicesPage clickInternetTab() {
        internetTab.click();
        return this;
    }

    public ServicesPage enterPhoneNumber(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public ServicesPage enterInternetAccountNumber(String value) {
        internetAccountInput.setValue(value);
        return this;
    }

    public ServicesPage enterSum(String value) {
        sumInput.setValue(value);
        return this;
    }

    public ServicesPage clickSbpMethod() {
        sbpMethodButton.click();
        return this;
    }

    public ServicesPage clickSbpMethodList() {
        sbpMethodListContainer.shouldBe(visible).click();
        return this;
    }

    public ServicesPage clickPaymentButton() {
        paymentButton.shouldBe(visible).click();
        return this;
    }

    public ServicesPage verifySbpPayment(String value) {
        sbpPaymentOutput.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    public ServicesPage verifySumOutput(String value) {
        sumOutput.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    public ServicesPage selectInternetSpeed100Mb() {
        internet100mbButton.click();
        return this;
    }

    public ServicesPage selectInternetSpeed500Mb() {
        internet500mbButton.click();
        return this;
    }

    public ServicesPage selectInternetSpeed600Mb() {
        internet600mbButton.click();
        return this;
    }

    public ServicesPage enterUserStreet(String value) {
        streetInput.shouldBe(visible).setValue(value);
        adressList
                .filter(Condition.exactText(value))
                .first()
                .click();
        return this;
    }

    public ServicesPage enterUserHouse(String value) {
        houseInput.shouldBe(visible).setValue(value);
        adressList
                .filter(Condition.exactText(value))
                .first()
                .click();
        return this;
    }

    public ServicesPage enterUserFlat(String value) {
        flatsInput.shouldBe(visible).setValue(value);
        return this;
    }

    public ServicesPage submitConnectionRequest() {
        connectionButton.shouldBe(visible).click();
        return this;
    }

    public ServicesPage enterUserPhoneNumber(String value) {
        phoneNumberInput.shouldBe(visible).setValue(value);
        return this;
    }

    public ServicesPage submitApplication() {
        userApplicationButton.shouldBe(visible).click();
        return this;
    }

    public ServicesPage verifyApplication(String value) {
        applicationAcceptedMessage.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    public ServicesPage enterEmailAdress(String value) {
        emailInput.setValue(value);
        return this;
    }

    public ServicesPage subscribeToNewsletter() {
        subscriptionButton.click();
        return this;
    }

    public ServicesPage verifySubscription(String value) {
        subscriptionOutput.shouldHave(text(value));
        return this;
    }
}
