package adapters;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

@Log4j2
public class ProjectApi extends BaseApi {

    @Step("Create project with title = '{project.title}' and code = '{project.code}'")
    public String create(Project project) {
        log.info("Create project with title = '{}' and code = '{}'",project.getTitle(), project.getCode());
        return   given().
                spec(specification).
                body(project).
        when().
                post(PropertyReader.getProperty("apiurl")+ "/v1/project").
        then().
                log().all().
                statusCode(200).
                extract().body().as(ProjectApiResponse.class).getResult().getCode();
    }

    @Step("Delete project with code =  '{code}'")
    public void deleteProject(String code) {
        log.info("Delete project with code =  '{}'", code);
        given().
                spec(specification).
        when().
                delete(PropertyReader.getProperty("apiurl")+ "/v1/project/" + code).
        then().
                log().all().
                statusCode(200);
    }
}
