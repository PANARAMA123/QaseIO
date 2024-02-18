package wrappers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchList {

    public void selectOption(String label, String option) {
        $(By.xpath(String.format("//label[text()='%s']/following::input",label))).click();
        sleep(1000);
        //$(By.xpath(String.format("//label[text()='%s']/following::input",label))).setValue(option);
        $(By.xpath(String.format("//*[text()='%s']//..//*[text()=' %s']",label, option))).shouldBe(Condition.visible);
    }
}