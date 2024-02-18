package tests;

import adapters.ProjectApi;
import adapters.SuiteApi;
import dto.Case;
import dto.Project;
import dto.Suite;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {

    @Test(description = "The user can create new Test Case on case creation page")
    public void createNewCaseOnCreationCasePage() {
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
        projectPage.goToCreateNewCase();
        Case newCase = Case.builder().
                title(faker.name().firstName()).
                build();
        createNewCasePage.createNewDefaultCase(newCase.getTitle());
        projectPage.checkThatNewCaseIsCreated(newCase.getTitle());
        new ProjectApi().deleteProject(project.getCode());
    }

    @Test(description = "The user can create new Test Case on project page")
    public void createNewCasesOnProjectPage() {
        Project project = Project.builder().
                title(faker.name().firstName()).
                code(faker.name().firstName().toUpperCase()).
                build();
        new ProjectApi().create(project);
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        Suite suite = Suite.builder().
                title(faker.name().firstName()).
                build();
        suite.setId(new SuiteApi().create(project,suite));
        projectPage.openPage(project.getCode());
        projectPage.waitUntilOpen();
        Case newCase = Case.builder().
                title(faker.name().firstName()).
                build();
        projectPage.createNewCaseIntoSuiteOnProjectPage(suite.getId(),newCase.getTitle());
        projectPage.checkThatNewCaseIsCreated(newCase.getTitle());
        new ProjectApi().deleteProject(project.getCode());
    }

    @Test(description = "The user can create new and fill out all fields")
    public void createNewCaseWithAllFields() {
        Project project = Project.builder().
                title(faker.name().firstName()).
                code(faker.name().firstName().toUpperCase()).
                build();
        new ProjectApi().create(project);
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        Suite suite = Suite.builder().
                title(faker.name().firstName()).
                build();
        suite.setId(new SuiteApi().create(project,suite));
        Case newCase = Case.builder().
                title(faker.name().firstName()).
                status("Draft").
                description(faker.name().title()).
                suite(suite.getTitle()).
                severity("Critical").
                priority("High").
                toBeAutomated(true).
                build();
        createNewCasePage.openPage(project.getCode());
        createNewCasePage.createNewCaseWithAllFields(newCase);
        projectPage.checkThatNewCaseIsCreated(newCase.getTitle());
        //new ProjectApi().deleteProject(project.getCode());
    }

    @Test(description = "The user can delete test case on project page")
    public void deleteCase() {
        Project project = Project.builder().
                title(faker.name().firstName()).
                code(faker.name().firstName().toUpperCase()).
                build();
        new ProjectApi().create(project);
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitUntilOpen();
        createNewCasePage.openPage(project.getCode());
        String caseName = faker.name().title();
        createNewCasePage.createNewDefaultCase(caseName);
        projectPage.deleteCase(caseName);
        projectPage.checkThatCaseIsDeleted(caseName);
        new ProjectApi().deleteProject(project.getCode());
    }
}
