package tests;

import adapters.ProjectApi;
import dto.Project;
import dto.Suite;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    @Test(description = "The user can create new suite on project page")
    public void createNewSuite() {
        Project project = Project.builder().
                title(faker.name().firstName()).
                code(faker.name().firstName().toUpperCase()).
                build();
        new ProjectApi().create(project);
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        projectPage.openPage(project.getCode());
        projectPage.waitUntilOpen();
        Suite suite = Suite.builder().
                title(faker.name().title()).
                build();
        projectPage.createNewSuite(suite.getTitle());
        projectPage.checkThatNewSuiteIsCreated(suite.getTitle());
        new ProjectApi().deleteProject(project.getCode());
    }
}
