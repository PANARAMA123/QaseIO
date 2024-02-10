package tests;

import adapters.ProjectApi;
import adapters.SuiteApi;
import dto.Case;
import dto.Project;
import dto.Suite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {
    private String projectCode;

    @Test
    public void createNewCase() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        projectsPage.createNewProject(faker.name().title());
        projectPage.waitUntilOpen();
        projectPage.goToCreateNewCase();
        createNewCasePage.createNewCase(faker.name().title());
    }

    @Test
    public void createNewCaseWithAPI() {
        Project project = Project.builder().
                title(faker.name().firstName()).
                code(faker.name().firstName().toUpperCase()).
                build();
        new ProjectApi().create(project);
        projectCode = project.getCode();
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        Suite suite = Suite.builder().
                title(faker.name().firstName()).
                build();
        suite.setId(new SuiteApi().create(project,suite));
        projectPage.openPage(project.getCode());
        projectPage.waitUntilOpen();
        Case case1 = Case.builder().
                title(faker.name().firstName()).
                build();
        projectPage.createNewCaseIntoSuite(suite.getId(),case1.getTitle());
        //projectPage.createNewSuite(faker.name().title());
    }
    @AfterTest
    public void clean() {
        new ProjectApi().deleteProject(projectCode);
    }
}
