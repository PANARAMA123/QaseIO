package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    final String EMAIL_CSS = "[name=email]";
    final String PASSWORD_CSS = "[name=password]";
    final String SUBMIT_BTN_CSS = "[type=submit]";
    final String EMPTY_FIELD_ERROR_MESSAGE_CSS = ".f75Cb_";
    final String ERROR_MESSAGE_CSS = ".ic9QAx";
    public void openPage() {
        open("/login");
    }

    public void login(String user, String pass) {
        open("/login");
        $(EMAIL_CSS).setValue(user);
        $(PASSWORD_CSS).setValue(pass);
        $(SUBMIT_BTN_CSS).click();
    }

    public String getEmptyFieldErrorMessage() {
        return $(EMPTY_FIELD_ERROR_MESSAGE_CSS).getText();
    }

    public String getErrorMessageFromBE() {
        return $(ERROR_MESSAGE_CSS).getText();
    }
}
