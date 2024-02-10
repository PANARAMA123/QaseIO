package tests;

import adapters.ProjectApi;
import dto.Project;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class SuiteTest extends BaseTest {
    private String projectCode;

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

    @Test
    public void createNewSuite() {
        Project project = Project.builder().
                title(faker.name().firstName()).
                code(faker.name().firstName().toUpperCase()).
                build();
        new ProjectApi().create(project);
        projectCode = project.getCode();
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        System.out.println(project.getCode());
        projectPage.openPage(project.getCode());
        projectPage.waitUntilOpen();
        projectPage.createNewSuite(faker.name().title());
    }

    @AfterTest
    public void clean() {
        new ProjectApi().deleteProject(projectCode);
    }
}
