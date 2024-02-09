package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    Faker faker;
    String user;
    String password;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 20000;
        Configuration.baseUrl = "https://app.qase.io";
        //Configuration.clickViaJs = true;
        open();
        getWebDriver().manage().window().maximize();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        //WebDriver driver = new ChromeDriver();
        //setWebDriver(driver);
        faker = new Faker();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();

        user = System.getProperty("user", PropertyReader.getProperty("qase.user"));
        System.out.println(user);
        password = System.getProperty("password", PropertyReader.getProperty("qase.password"));
        System.out.println(password);
    }

    @AfterMethod
    public void closeBrowser() {
//        if (getWebDriver() != null) {
//        getWebDriver().quit();
//        }
        closeWebDriver();
    }
}
