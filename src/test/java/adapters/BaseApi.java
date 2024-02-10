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
        System.out.println(System.getenv().getOrDefault("apitoken", PropertyReader.getProperty("qase.apitoken")));
        spec = given().
                header("Token", System.getenv().getOrDefault("apitoken", PropertyReader.getProperty("qase.apitoken"))).
                header("Content-Type", "application/json");
    }
}