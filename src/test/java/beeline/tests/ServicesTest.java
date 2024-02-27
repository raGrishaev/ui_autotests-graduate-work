package beeline.tests;

import beeline.pages.ServicesPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@Owner("Anton Melnikov")
@Feature("Тестирование страницы услуг Билайн")
@Tag("ui")
public class ServicesTest extends TestBase {

    ServicesPage servicesPage = new ServicesPage();
    TestData testData = new TestData();

    @ParameterizedTest
    @DisplayName("Тест пополнения счетов Билайн ")
    @Story("Тест пополнения номера телефона и личного кабинета Билайн через систему быстрых платежей")
    @Tag("payment")
    @Severity(SeverityLevel.BLOCKER)
    @ValueSource(strings = {"Телефон", "Интернет"})
    void servicePaymentTest(String serviceType) {
        step("Открываем страницу с услугами", () -> {
            servicesPage.openServicesPage();
        });
        step("Кликаем и заполняем поле " + serviceType, () -> {
            switch (serviceType) {
                case "Телефон":
                    servicesPage.clickPhoneTab();
                    servicesPage.enterPhoneNumber(testData.phoneNumberBeeline);
                    break;
                case "Интернет":
                    servicesPage.clickInternetTab();
                    servicesPage.enterInternetAccountNumber(testData.accountNumberBeeline);
                    break;
            }
            servicesPage.enterSum(testData.sumToPay);

        });
        step("Кликаем на способ оплаты и выбираем СБП", () -> {
            servicesPage.clickSbpMethod()
                    .clickSbpMethodList();
        });
        step("Кликаем оплатить через СБП", () -> {
            servicesPage.clickPaymentButton();
        });
        step("Проверяем вид оплаты и сумму платежа", () -> {
            servicesPage.verifySbpPayment("Оплата через СБП");
            servicesPage.verifySumOutput("К оплате " + testData.sumToPay + " ₽");
        });
    }

    @ParameterizedTest
    @DisplayName("Тест заполнения форм на подключение домашнего интернета")
    @Story("Проверка заполнения форм подключения домашнего интернета" +
            " с успешной территориальной возможностью подключения")
    @Tag("internethome")
    @Severity(SeverityLevel.BLOCKER)
    @ValueSource(strings = {"100mb", "500mb", "600mb"})
    void internetConnectionTest(String rateType) {
        step("Открываем страницу с услугами", () -> {
            servicesPage.openServicesPage();
        });
        step("Кликаем кнопку с указанием скорости интернета" + rateType, () -> {
            switch (rateType) {
                case "100mb":
                    servicesPage.selectInternetSpeed100Mb();
                    break;
                case "500mb":
                    servicesPage.selectInternetSpeed500Mb();
                    break;
                case "600mb":
                    servicesPage.selectInternetSpeed600Mb();
            }
        });
        step("Заполняем строки возможного подключения 'Улица', 'Дом', 'Квартира'", () -> {
            servicesPage.enterUserStreet(testData.street)
                    .enterUserHouse(testData.house)
                    .enterUserFlat(testData.flat);
        });
        step("Кликаем на кнопку 'Подключить'", () -> {
            servicesPage.submitConnectionRequest();
        });
        step("Вводим контактный номер телефона для обратной связи", () -> {
            servicesPage.enterUserPhoneNumber(testData.phoneNumberFeedback);
        });
        step("Кликаем на кнопку 'Подтвердить'", () -> {
            servicesPage.submitApplication();
        });
        step("Проверяем, что заявка принята", () -> {
            servicesPage.verifyApplication("Заявка принята!");
        });
    }

}
