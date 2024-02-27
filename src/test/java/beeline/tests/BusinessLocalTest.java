package beeline.tests;

import beeline.pages.BusinessLocalPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("Anton Melnikov")
@Feature("Тестирование языка текста раздела 'Билайн Бизнес'")
@Tags({@Tag("ui"), @Tag("language")})
public class BusinessLocalTest extends TestBase {

    BusinessLocalPage businessLocalPage = new BusinessLocalPage();

    @Test
    @DisplayName("Тестирование переключения языка текста")
    @Story("Тестирование смены языка текста с русского на английский, после нажатия кнопки 'English version")
    @Severity(SeverityLevel.CRITICAL)
    void languageOnThePageTest() {

        step("Открываем страницу Билайн Бизнес (Операторам связи)", () -> {
            businessLocalPage.openBusinessPage();
        });
        step("Проверяем, что на заголовок и подзаголовок отображаются на русском языке", () -> {
            businessLocalPage.checkBannerTitle("Операторам связи");
            businessLocalPage.checkDetailsMainText("Ваш выход на новый уровень операторского бизнеса");
        });
        step("Кликаем на кнопку 'English version'", () -> {
            businessLocalPage.pressEnglishVersionButton();
        });
        step("Проверяем, что заголовок и подзаголовок переключились на английский язык", () -> {
            businessLocalPage.checkBannerTitle("For telecom carriers");
            businessLocalPage.checkDetailsMainText("Your upgrade to a new level of a carrier business");
        });
    }
}
