package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    @Test
    public void createNewSuite() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(faker.name().title());
        projectPage.waitUntilOpen();
        projectPage.createNewSuite(faker.name().title());
    }

    @Test
    public void deleteSuite() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        projectsPage.createNewProject(faker.name().title());
        projectPage.waitUntilOpen();
        projectPage.goToCreateNewCase();
        String caseName = faker.name().title();
        createNewCasePage.createNewCase(caseName);
        projectPage.deleteCase(caseName);

    }
}
