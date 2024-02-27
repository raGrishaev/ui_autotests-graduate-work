package tests;

import pages.ShopSearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@Owner("Anton Melnikov")
@Feature("Тестирование раздела поиска страницы магазина Билайн")
@Tags({@Tag("ui"), @Tag("search")})
public class ShopSearchTest extends TestBase {

    ShopSearchPage shopSearchPage = new ShopSearchPage();

    @ParameterizedTest
    @DisplayName("Тест поисковой строки магазина")
    @Story("Проверка вывода результата поиска после ввода значений")
    @Severity(SeverityLevel.BLOCKER)
    @ValueSource(strings = {"iPhone 14pro", "Тариф Up. Панда Тапа", "Kaspersky Plus"})
    void searchPositiveTest(String searchQuery) {

        step("Открываем страницу магазина Билайн", () -> {
            shopSearchPage.openShopPage();
            shopSearchPage.closeTableLocal();
        });
        step("Кликаем на поле поиска", () -> {
            shopSearchPage.clickSearchField();
        });
        step("Вводим поисковый запрос: " + searchQuery, () -> {
            shopSearchPage.enterSearchQuery(searchQuery);
        });
        step("Нажимаем Enter для поиска", () -> {
            shopSearchPage.initiateSearch();
        });
        step("Проверяем результаты поиска", () -> {
            shopSearchPage.verifySearchResults(searchQuery);
        });

    }

}



