package tests.testcase;

import com.github.javafaker.Faker;
import models.lombok.TestCaseTreeLeafRequestBodyLombok;
import models.lombok.TestCaseTreeLeafResponseBodyLombok;
import models.pojo.TestCaseTreeLeafRequestBodyPojo;
import models.pojo.TestCaseTreeLeafResponseBodyPojo;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static api.AuthorizationApi.XSRF_TOKEN;
import static api.AuthorizationApi.getAllureTestopsSession;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.createTestCaseRequestSpec;
import static specs.Specs.createTestCaseResponseSpec;

public class CreateTestCaseTests extends TestBase {

    static final String PROJECT_ID = "1411";

    @Test
    void createTestCase() {
        Faker faker = new Faker();

        String testName = faker.team().name();
        String body = "{\"name\":\"" + testName + "\"}";

        given()
                .header("X-XSRF-TOKEN", XSRF_TOKEN)
                .cookies("XSRF-TOKEN", XSRF_TOKEN,
                        "ALLURE_TESTOPS_SESSION", getAllureTestopsSession())
                .queryParam("projectId", PROJECT_ID)
                .contentType(JSON)
                .body(body)
                .log().all()
                .when()
                .post("/rs/testcasetree/leaf")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is(testName))
                .body("automated", is(false));
    }


    @Test
    void createTestCaseWithPojoModels() {
        Faker faker = new Faker();
        String testName = faker.team().name();

        TestCaseTreeLeafRequestBodyPojo body = new TestCaseTreeLeafRequestBodyPojo();
        body.setName(testName);

        TestCaseTreeLeafResponseBodyPojo response = given()
                .header("X-XSRF-TOKEN", XSRF_TOKEN)
                .cookies("XSRF-TOKEN", XSRF_TOKEN,
                        "ALLURE_TESTOPS_SESSION", getAllureTestopsSession())
                .queryParam("projectId", PROJECT_ID)
                .contentType(JSON)
                .body(body.toString())
                .log().all()
                .when()
                .post("/rs/testcasetree/leaf")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(TestCaseTreeLeafResponseBodyPojo.class);

        assertEquals(testName, response.getName());
        assertEquals(false, response.getAutomated());
    }

    @Test
    void createTestCaseWithLombokModels() {
        Faker faker = new Faker();
        String testName = faker.team().name();

        TestCaseTreeLeafRequestBodyLombok body = new TestCaseTreeLeafRequestBodyLombok();
        body.setName(testName);

        TestCaseTreeLeafResponseBodyLombok response = given()
                .header("X-XSRF-TOKEN", XSRF_TOKEN)
                .cookies("XSRF-TOKEN", XSRF_TOKEN,
                        "ALLURE_TESTOPS_SESSION", getAllureTestopsSession())
                .queryParam("projectId", PROJECT_ID)
                .contentType(JSON)
                .body(body.toString())
                .log().all()
                .when()
                .post("/rs/testcasetree/leaf")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(TestCaseTreeLeafResponseBodyLombok.class);

        assertEquals(testName, response.getName());
        assertEquals(false, response.getAutomated());
    }

    @Test
    void createTestCaseWithSpecs() {
        Faker faker = new Faker();
        String testName = faker.team().name();

        TestCaseTreeLeafRequestBodyLombok body = new TestCaseTreeLeafRequestBodyLombok();
        body.setName(testName);

        TestCaseTreeLeafResponseBodyLombok response = given()
                .spec(createTestCaseRequestSpec)
                .queryParam("projectId", PROJECT_ID)
                .body(body.toString())
                .when()
                .post("/testcasetree/leaf")
                .then()
                .spec(createTestCaseResponseSpec)
                .log().all()
                .extract().as(TestCaseTreeLeafResponseBodyLombok.class);

        assertEquals(testName, response.getName());
        assertEquals(false, response.getAutomated());
    }

}
