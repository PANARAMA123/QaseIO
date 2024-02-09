package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "The user can create new project")
    public void createNewProject() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        projectsPage.createNewProject("test", "TEST1","jhk");
        projectPage.waitUntilOpen();
        assertTrue(
                projectPage.getProjectCodeName().contains("TEST1" + " repository"),
                "Wrong project name");
        assertTrue(
                projectPage.getProjectName().contains("test"),
                "Wrong project name");
        assertTrue(
                projectPage.getProjectUrl().contains("https://app.qase.io/project/TEST1"),
                "Wrong URL");
    }
}
