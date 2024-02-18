package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckBox {

    public void selectCheckbox(String label) {
        $(By.xpath(String.format("//label[text()='%s']//..//input[@type='checkbox']",label))).click();
    }
}