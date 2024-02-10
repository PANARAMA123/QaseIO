package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    final String EMAIL_CSS = "[name=email]";
    final String PASSWORD_CSS = "[name=password]";
    final String SUBMIT_BTN_CSS = "[type=submit]";
    final String EMPTY_FIELD_ERROR_MESSAGE_CSS = ".f75Cb_";
    final String ERROR_MESSAGE_CSS = ".ic9QAx";

    @Step("Opening the login page by link")
    public void openPage() {
        open("/login");
    }

    @Step("Login by {user}")
    public void login(String user, String pass) {
        open("/login");
        log.info("Login by '{}' with password '{}'",user,pass );
        $(EMAIL_CSS).setValue(user);
        $(PASSWORD_CSS).setValue(pass);
        $(SUBMIT_BTN_CSS).click();
    }

    @Step("Getting the error message")
    public String getEmptyFieldErrorMessage() {
        return $(EMPTY_FIELD_ERROR_MESSAGE_CSS).getText();
    }

    @Step("Getting the error message")
    public String getErrorMessageFromBE() {
        return $(ERROR_MESSAGE_CSS).getText();
    }
}
