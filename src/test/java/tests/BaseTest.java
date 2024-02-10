package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CreateNewCasePage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    CreateNewCasePage createNewCasePage;
    Faker faker;
    String user;
    String password;
    String apiToken;

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
        createNewCasePage = new CreateNewCasePage();
        user = System.getenv().getOrDefault("user", PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("password", PropertyReader.getProperty("qase.password"));
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
    }
}
