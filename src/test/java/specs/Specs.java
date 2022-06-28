package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.AuthorizationApi.XSRF_TOKEN;
import static api.AuthorizationApi.getAllureTestopsSession;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class Specs {
    public static RequestSpecification createTestCaseRequestSpec = with()
            .header("X-XSRF-TOKEN", XSRF_TOKEN)
            .cookies("XSRF-TOKEN", XSRF_TOKEN,
                    "ALLURE_TESTOPS_SESSION", getAllureTestopsSession())
            .basePath("/rs")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification createTestCaseResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
//            .expectBody(containsString("success"))
            .build();
}
