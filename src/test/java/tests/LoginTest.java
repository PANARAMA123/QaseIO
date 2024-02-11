package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "The user should login with the correct credentials")
    public void loginWithValidCredentials()  {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
    }

    @DataProvider
    public Object[][] loginDataForFEValidation() {
        return new Object[][]{
                {"", "password", "This field is required"},
                {"user_name", "", "This field is required"}
        };
    }

    @Test(dataProvider = "loginDataForFEValidation", description = "Error message should displayed if required fields are empty")
    public void negativeLoginFE(String user, String password, String expectedError)  {
        loginPage.openPage();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getEmptyFieldErrorMessage(),
                expectedError,
                "Wrong error massage");
    }

    @DataProvider
    public Object[][] loginDataForBEValidation() {
        return new Object[][]{
                {"not_valid_user_name", "wrong_password", "Value 'not_valid_user_name' does not match format email of type string"},
                {"wrong_user_name@mail.com", "wrong_password", "These credentials do not match our records."},
                {"ddmitrochenko@gmail.com", "wrong_password", "These credentials do not match our records."},
        };
    }
    @Test(dataProvider = "loginDataForBEValidation", description = "Error message should displayed if not valid credentials were filled out")
    public void negativeLoginBE(String user, String password, String expectedError)  {
        loginPage.openPage();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getErrorMessageFromBE(),
                expectedError,
                "Wrong error massage");
    }
}
