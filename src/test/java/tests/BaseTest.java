package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.NewCaseCreationPage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsPage;
import tests.base.TestListener;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    NewCaseCreationPage createNewCasePage;
    Faker faker;
    String user;
    String password;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 25000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();
        faker = new Faker();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();
        createNewCasePage = new NewCaseCreationPage();
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
    }
}
