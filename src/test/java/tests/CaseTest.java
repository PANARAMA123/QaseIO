package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {

    @Test
    public void createNewCase() {
        loginPage.openPage();
        loginPage.login(user, password);

        projectsPage.createNewProject(faker.name().title());
        projectPage.waitUntilOpen();
        projectPage.goToCreateNewCase();
        createNewCasePage.createNewCase(faker.name().title());
    }
}
