package pages;

import com.codeborne.selenide.Condition;
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
    final  String CONFIRM_INPUT_CSS = "[name=confirm]";



    public void openPage(String projectCode) {
        open("/project/"+ projectCode);
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
        log.info("Create new suite with name = '{}'",suiteName );
        $(CREATE_NEW_SUITE_BTN_CSS).click();
        $(NEW_SUITE_TITLE_CSS).setValue(suiteName).submit();
    }
    public void deleteCase(String caseName) {
        log.info("Delete case with name =  '{}'",caseName );
        $(By.xpath(String.format(CHECKBOX_FOR_CASE_XPATH,caseName))).click();
        $(By.xpath(DELETE_CASE_BTN_XPATH)).click();
        $(CONFIRM_INPUT_CSS).setValue("CONFIRM");
        $(By.xpath(SUBMIT_BTN_XPATH)).click();
    }
    public void createNewCaseIntoSuiteOnProjectPage(int idSuite, String caseTitle) {
        log.info("Create new case with name = '{}'",caseTitle );
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH,idSuite))).click();
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH,idSuite))).setValue(caseTitle).submit();
    }
    public void createNewCaseWithoutSuite(String caseTitle) {
        log.info("Create new case with name = '{}'",caseTitle );
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH, 0))).click();
        $(By.xpath(String.format(CREATE_NEW_CASE_INTO_SUITE_XPATH, 0))).setValue(caseTitle).submit();
    }
    public void checkThatNewCaseIsCreated(String caseTitle) {
        $(By.xpath(String.format(CASE_TITLE_XPATH, caseTitle))).shouldBe(Condition.visible);
    }
    public void checkThatCaseIsDeleted(String caseTitle) {
        $(By.xpath(String.format(CASE_TITLE_XPATH, caseTitle))).shouldNotBe(Condition.visible);
    }
}
