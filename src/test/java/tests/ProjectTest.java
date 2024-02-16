package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "The user can create new project")
    public void createNewProject() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        String projectName = faker.name().firstName();
        projectsPage.createNewProject(projectName, projectName.toUpperCase(),"jhk");
        projectPage.waitUntilOpen();
        assertTrue(
                projectPage.getProjectCodeName().contains(projectName.toUpperCase() + " repository"),
                "Wrong project name");
        assertTrue(
                projectPage.getProjectName().contains(projectName),
                "Wrong project name");
        assertTrue(projectPage.getProjectUrl().contains("https://app.qase.io/project/" + projectName.toUpperCase()),
                "Wrong URL");
    }
}
