package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    @Test
    public void createNewSuite() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(faker.name().title());
        projectPage.waitUntilOpen();
        projectPage.createNewSuit(faker.name().title());
    }
}
