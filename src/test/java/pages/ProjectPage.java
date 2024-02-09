package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProjectPage {

    final String TITLE_REPOSITORY_CODE_NAME_XPATH = "//h1";
    final String TITLE_REPOSITORY_NAME_CSS = ".Qt9eBT";
    final  String CREATE_NEW_SUITE_BTN_CSS = "#create-suite-button";
    final  String CREATE_NEW_CASE_BTN_CSS = "#create-case-button";
    final  String NEW_SUITE_TITLE_CSS = "#title";
    final  String DELETE_CASE_BTN_XPATH = "//div[@id='application-content']//button[text()=' Delete']";
    final  String SUBMIT_BTN_XPATH = "//form//button[@type='submit']";
    final  String CHECKBOX_FOR_CASE_XPATH = "//div[text()='%s']//..//input";


    public void openPage() {
        open("/project");
    }
    public void waitUntilOpen() {
        $(CREATE_NEW_SUITE_BTN_CSS).shouldBe(Condition.visible);
    }

    public String getProjectCodeName() {
        return $(By.xpath(TITLE_REPOSITORY_CODE_NAME_XPATH)).getText();
    }
    public String getProjectName() {
        return $(TITLE_REPOSITORY_NAME_CSS).getText();
    }
    public String getProjectUrl() {
        getWebDriver().getCurrentUrl();
        return getWebDriver().getCurrentUrl();
    }
    public void goToCreateNewCase() {
        $(CREATE_NEW_CASE_BTN_CSS).click();
    }
    public void createNewSuite(String suiteName) {
        $(CREATE_NEW_SUITE_BTN_CSS).click();
        $(NEW_SUITE_TITLE_CSS).setValue(suiteName).submit();
    }
    public void deleteCase(String suiteName) {
        $(By.xpath(String.format(CHECKBOX_FOR_CASE_XPATH,suiteName))).click();
        $(By.xpath(DELETE_CASE_BTN_XPATH)).click();
        $(By.xpath(SUBMIT_BTN_XPATH)).click();

    }

}
