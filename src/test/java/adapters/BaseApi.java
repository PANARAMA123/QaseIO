package adapters;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseApi {

    RequestSpecification specification;

    public BaseApi() {
        setup();
    }

    public void setup() {
        specification = given().
                header("Token", System.getProperty("apitoken", PropertyReader.getProperty("apitoken"))).
                header("Content-Type", "application/json");
    }
}