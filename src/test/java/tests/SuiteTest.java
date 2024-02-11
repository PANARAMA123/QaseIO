package tests;

import adapters.ProjectApi;
import dto.Project;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SuiteTest extends BaseTest {

    @Test
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
        projectPage.createNewSuite(faker.name().title());
        new ProjectApi().deleteProject(project.getCode());
    }
}
