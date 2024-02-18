package wrappers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchList {

    public void selectOption(String label, String option) {
        $(By.xpath(String.format("//label[text()='%s']//..//div",label))).shouldBe(Condition.visible).click();
        $(By.xpath(String.format("//div[text()='%s']", option))).shouldBe(Condition.visible).click();
    }
}