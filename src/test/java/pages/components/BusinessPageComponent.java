package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BusinessPageComponent {

    private final SelenideElement menuPanel = $(By.cssSelector("ul[data-test-id='menuPanel']"));

    public BusinessPageComponent openBusinessMainPage() {
        open("/business/main/");
        return this;
    }

    public BusinessPageComponent waitForMenuPanel() {
        menuPanel.shouldBe(Condition.visible);
        return this;
    }

    public BusinessPageComponent verifyMenuItems(List<String> expectedItems) {
        for (String expectedItem : expectedItems) {
            SelenideElement listItem = menuPanel.$x(".//li[.//*[contains(text(), '" + expectedItem + "')]]");
            listItem.shouldBe(Condition.visible);
            verifyMenuItemClickable(listItem);
        }
        return this;

    }

    public BusinessPageComponent verifyMenuItemClickable(SelenideElement menuItem) {
        menuItem.shouldBe(Condition.enabled);
        return this;
    }

}
