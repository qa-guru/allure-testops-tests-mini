package tests.testcase;

import com.github.javafaker.Faker;
import models.lombok.testcase.create.request.CreateTestCaseRequestBody;
import models.lombok.TestCaseTreeLeafRequestBodyLombok;
import models.lombok.TestCaseTreeLeafResponseBodyLombok;
import models.lombok.testcase.create.request.Status;
import models.lombok.testcase.create.response.CreateTestCaseResponseBody;
import models.pojo.TestCaseTreeLeafRequestBodyPojo;
import models.pojo.TestCaseTreeLeafResponseBodyPojo;
import org.junit.jupiter.api.BeforeEach;
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

    Faker faker = new Faker();
    String testName;

    static final String PROJECT_ID = "1411";

    @BeforeEach
    void setUpTestData() {
        testName = faker.team().name();
    }

    @Test
    void createTestCaseLeaf() {
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

        response.setAutomated(true);

        assertEquals(testName, response.getName());
    }

    @Test
    void createTestCaseWithSpecs() {
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

    @Test
    void createTestCase() {
        CreateTestCaseRequestBody body = new CreateTestCaseRequestBody();
        body.setProjectId(PROJECT_ID);
        body.setName(testName);

        Status status = new Status();
        status.setId(-1);
        status.setName("Draft");

        body.setStatus(status);

        CreateTestCaseResponseBody response = given()
                .spec(createTestCaseRequestSpec)
                .body(body.toString())
                .when()
                .post("/testcase")
                .then()
                .spec(createTestCaseResponseSpec)
                .log().all()
                .extract().as(CreateTestCaseResponseBody.class);

        assertEquals(testName, response.getName());
    }


}
