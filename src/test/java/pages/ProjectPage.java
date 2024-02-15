package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
public class ProjectPage {

    final String TITLE_REPOSITORY_CODE_NAME_XPATH = "//h1";
    final String TITLE_REPOSITORY_NAME_CSS = ".Qt9eBT";
    final  String CREATE_NEW_SUITE_BTN_CSS = "#create-suite-button";
    final  String CREATE_NEW_CASE_BTN_CSS = "#create-case-button";
    final  String NEW_SUITE_TITLE_CSS = "#title";
    final  String DELETE_CASE_BTN_XPATH = "//div[@id='application-content']//button[text()=' Delete']";
    final  String SUBMIT_BTN_XPATH = "//form//button[@type='submit']";
    final  String CHECKBOX_FOR_CASE_XPATH = "//div[text()='%s']//..//input";
    final  String CREATE_NEW_CASE_INTO_SUITE_XPATH = "//div[@data-suite-body-id='%s']/../../following-sibling::*//input";
    final  String CASE_TITLE_XPATH = "//div[text()='%s']";
    final  String SUITE_TITLE_XPATH = "//a[@title='%s']";
    final  String CONFIRM_INPUT_CSS = "[name=confirm]";


    @Step("Opening the project page by link")
    public void openPage(String projectCode) {
        open("/project/"+ projectCode);
    }

    @Step("Wait until project page be opened")
    public void waitUntilOpen() {
        $(CREATE_NEW_SUITE_BTN_CSS).shouldBe(Condition.visible);
    }

    @Step("Getting project code")
    public String getProjectCodeName() {
        return $(By.xpath(TITLE_REPOSITORY_CODE_NAME_XPATH)).getText();
    }
    @Step("Getting project name")
    public String getProjectName() {
        return $(TITLE_REPOSITORY_NAME_CSS).getText();
    }

    @Step("Getting current page url")
    public String getProjectUrl() {
        getWebDriver().getCurrentUrl();
        return getWebDriver().getCurrentUrl();
    }
    @Step("Opening the creation new case page")
    public void goToCreateNewCase() {
        $(CREATE_NEW_CASE_BTN_CSS).click();
    }
    @Step("Creating new suite")
    public void createNewSuite(String suiteName) {
        log.info("Create new suite with name = '{}'",suiteName );
        $(CREATE_NEW_SUITE_BTN_CSS).click();
        $(NEW_SUITE_TITLE_CSS).setValue(suiteName).submit();
    }
    @Step("Deleting test case with title = {caseName}")
    public void deleteCase(String caseName) {
        log.info("Delete case with name =  '{}'",caseName );
        $(By.xpath(String.format(CHECKBOX_FOR_CASE_XPATH,caseName))).click();
        $(By.xpath(DELETE_CASE_BTN_XPATH)).click();
        $(CONFIRM_INPUT_CSS).setValue("CONFIRM");
        $(By.xpath(SUBMIT_BTN_XPATH)).click();
    }
    @Step("Creating new test case on suite page with title = {caseTitle}")
    public void createNewCaseIntoSuiteOnProjectPage(int idSuite, String caseTitle) {
        log.info("Create new case with name = '{}'",caseTitle );
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH,idSuite))).click();
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH,idSuite))).setValue(caseTitle).submit();
    }
/*
    public void createNewCaseWithoutSuite(String caseTitle) {
        log.info("Create new case with name = '{}'",caseTitle );
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH, 0))).click();
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH, 0))).setValue(caseTitle).submit();
    }*/
    @Step("Checking that test with title = {caseTitle} is created")
    public void checkThatNewCaseIsCreated(String caseTitle) {
        $(By.xpath(String.format(CASE_TITLE_XPATH, caseTitle))).shouldBe(Condition.visible);
    }
    @Step("Checking that test with title = {caseTitle} is deleted")
    public void checkThatCaseIsDeleted(String caseTitle) {
        $(By.xpath(String.format(CASE_TITLE_XPATH, caseTitle))).shouldNotBe(Condition.visible);
    }
    @Step("Checking that suite with title = {caseTitle} is created")
    public void checkThatNewSuiteIsCreated(String suiteName) {
        log.info("Check that new suite with name = '{}' is created",suiteName );
        $(By.xpath(String.format(SUITE_TITLE_XPATH, suiteName))).shouldNotBe(Condition.visible);
    }
}
