package pages;

import dto.Case;
import dto.Project;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
@Log4j2
public class NewCaseCreationPage {
    final String TITLE_CSS = "#title";
    final String TITLE_XPATH = "[//label[text()='Description']/..//p]";
    final String SAVE_BTN_CSS = "#save-case";

    public void openPage(String projectCode) {
        open("/case/" + projectCode + "/create");
    }
    public void createNewDefaultCase(String caseTitle) {
        log.info("Create new case with title = '{}'",caseTitle);
        $(TITLE_CSS).sendKeys(caseTitle);
        $(SAVE_BTN_CSS).click();
    }
    public void createNewCaseWithAllFields(Case newCase) {
        $(TITLE_CSS).sendKeys(newCase.getTitle());
        new DropDown().selectOption("Status", newCase.getStatus());
        $(SAVE_BTN_CSS).click();
    }
}
