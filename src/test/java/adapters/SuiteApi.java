package adapters;

import dto.Project;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

@Log4j2
public class SuiteApi extends BaseApi {

    @Step("Create suite with title = '{suite.title}'")
    public int create(Project project, Suite suite) {
        log.info("Create suite with title = '{}' in project = '{}'",suite.getTitle(),project.getCode());
        System.out.println(suite);
        return given().
                spec(specification).
                body(suite).
           when().
                post(PropertyReader.getProperty("apiurl")+ "/v1/suite/" + project.getCode()).
           then().
                log().all().
                statusCode(200).extract().as(SuiteApiResponse.class).getResult().getId();
    }
}
