package beeline.tests;

import beeline.pages.ServicesPage;
import beeline.utils.RandomUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("Anton Melnikov")
@Feature("Тестирование подписки на новости Билайн")
@Tags({@Tag("ui"), @Tag("subscription")})
public class SubscriptionTest extends TestBase {

    ServicesPage servicesPage = new ServicesPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Успешная подписка на новости Билайн")
    @Story("Тест подписки на новости Билайн, с заполнением случайного Email")
    @Severity(SeverityLevel.CRITICAL)
    void subscriptionNewsTest() {

        step("Открываем страницу с услугами", () -> {
            servicesPage.openServicesPage();
        });
        step("Вводим почтовый адрес", () -> {
            servicesPage.enterEmailAdress(randomUtils.fakerEmail());
        });
        step("Кликаем на таб Подписаться", () -> {
            servicesPage.subscribeToNewsletter();
        });
        step("Проверяем подписку на новости Билайн", () -> {
            servicesPage.verifySubscription("Поздравляем, ты успешно подписался на рассылку билайна");
        });

    }

}
