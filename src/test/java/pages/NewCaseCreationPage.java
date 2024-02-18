package pages;

import dto.Case;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.CheckBox;
import wrappers.DropDown;
import wrappers.SearchList;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class NewCaseCreationPage {
    final String TITLE_CSS = "#title";
    final String TITLE_XPATH = "[//label[text()='Description']/..//p]";
    final String SAVE_BTN_CSS = "#save-case";

    @Step("Opening the creation case page by link")
    public void openPage(String projectCode) {
        open("/case/" + projectCode + "/create");
    }
    @Step("Creation new Case with title = {caseTitle}")
    public void createNewDefaultCase(String caseTitle) {
        log.info("Create new case with title = '{}'",caseTitle);
        $(TITLE_CSS).sendKeys(caseTitle);
        $(SAVE_BTN_CSS).click();
    }
    @Step("Creation new Case with all filled fields")
    public void createNewCaseWithAllFields(Case newCase) {
        $(TITLE_CSS).sendKeys(newCase.getTitle());
        new DropDown().selectOption("Status", newCase.getStatus());
        new SearchList().selectOption("Suite", newCase.getSuite());
        new DropDown().selectOption("Severity", newCase.getSeverity());
        new DropDown().selectOption("Priority", newCase.getPriority());
        if (newCase.isToBeAutomated()) {
            new CheckBox().selectCheckbox("To be automated");
        }
        $(SAVE_BTN_CSS).click();
    }
}
