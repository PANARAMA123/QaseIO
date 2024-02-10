package adapters;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseApi {

    RequestSpecification spec;

    public BaseApi() {
        setup();
    }

    public void setup() {
        spec = given().
                header("Token", System.getenv().getOrDefault("apitoken", PropertyReader.getProperty("apitoken"))).
                header("Content-Type", "application/json");
    }
}