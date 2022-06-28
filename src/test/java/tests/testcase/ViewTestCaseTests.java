package tests.testcase;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static api.AuthorizationApi.getAllureTestopsSession;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ViewTestCaseTests extends TestBase {

    @Test
    void viewTestCase() {
        given()
                .cookie("ALLURE_TESTOPS_SESSION", "317be161-f7eb-4180-bd5e-77a0eddb489e")
                .log().all()
                .when()
                .get("/rs/testcase/10757")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("First test"));
    }

    @Test
    void viewTestCaseWithAuthorization() {
        String username = "allure8",
                password = "allure8",
                xsrfToken = "12345";

        String allureTestopsSession =  given()
                .header("X-XSRF-TOKEN", xsrfToken)
                .header("Cookie", "XSRF-TOKEN=" + xsrfToken)
                .formParam("username", username)
                .formParam("password", password)
                .log().all()
                .when()
                .post("/login/system")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response()
                .getCookie("ALLURE_TESTOPS_SESSION");

        given()
                .cookie("ALLURE_TESTOPS_SESSION", allureTestopsSession)
                .log().all()
                .when()
                .get("/rs/testcase/10757")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("First test"));
    }

    @Test
    void viewTestCaseWithAuthorizationFromApiModule() {
        given()
                .cookie("ALLURE_TESTOPS_SESSION", getAllureTestopsSession())
                .log().all()
                .when()
                .get("/rs/testcase/10757")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("First test"));
    }

    @Test
    void createTestCase() {
        given()
                .cookie("ALLURE_TESTOPS_SESSION", getAllureTestopsSession())
                .log().all()
                .when()
                .get("/rs/testcase/10757")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("First test"));
    }


}
