package beeline.tests;

import beeline.pages.BasketPage;
import beeline.pages.ProductPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("Anton Melnikov")
@Feature("Тестирование содержимого раздела 'Корзина'")
@Tags({@Tag("ui"), @Tag("basket")})
public class BasketTest extends TestBase {
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @Test
    @DisplayName("Тестирование добавления товара в корзину")
    @Story("Тестирование добавления товара в корзину с проверкой наличия, количества и стоимости товара")
    @Severity(SeverityLevel.BLOCKER)
    void basketAddingTest() {

        step("Открываем страницу с товаром 'Kaspersky Cloud Password Manager'", () -> {
            productPage.openProductPage();
        });
        step("Нажимаем на кнопку 'В корзину'", () -> {
            productPage.addToBasket();
        });
        step("Открываем раздел сайта 'Корзина'", () -> {
            productPage.goToBasket();
        });
        step("Проверяем наличие товара в корзине, количество и его стоимость", () -> {
            basketPage.verifyProductTitle("Kaspersky Cloud Password Manager");
            basketPage.verifyProductQuantity("1");
            basketPage.verifyProductPrice("1 499 ₽");
        });

    }

    @Test
    @DisplayName("Тестирование удаления товара из корзины")
    @Story("Тестирование удаления товара из корзины с проверкой наличия товара")
    @Severity(SeverityLevel.BLOCKER)
    void basketRemovalTest() {

        step("Открываем страницу с товаром", () -> {
            productPage.openProductPage();
        });
        step("Нажимаем на таб В корзину", () -> {
            productPage.addToBasket();
        });
        step("Открываем раздел сайта 'Корзина'", () -> {
            productPage.goToBasket();
        });
        step("Удаляем товар из корзины", () -> {
            basketPage.deleteProduct();
        });
        step("Проверяем наличие удаленного товара в корзине", () -> {
            basketPage.verifyRemovalInfo("Товар «Программное обеспечение Kaspersky Cloud Password Manager" +
                    " — 1 год, 1 устройство» удален.");
        });

    }

}
