package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDown {

    public void selectOption(String lable, String option) {
        $(By.xpath(String.format("//label[text()='%s']/following::div",lable))).click();
        $(By.xpath(String.format("//div[@id='modals']//div[text()='%s']",option))).click();
    }
}