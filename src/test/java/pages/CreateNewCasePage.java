package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateNewCasePage {
    final String TITLE_CSS = "#title";
    final String TITLE_XPATH = "[//label[text()='Description']/..//p]";
    final String SAVE_BTN_CSS = "#save-case";



    public void openPage() {

        //TBD придумать как получать урл
        open("/login");
    }
    public void createNewCase(String caseTitle) {
        $(TITLE_CSS).sendKeys(caseTitle);
        $(SAVE_BTN_CSS).click();
    }
}
