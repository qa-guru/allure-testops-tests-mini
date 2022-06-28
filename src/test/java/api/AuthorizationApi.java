package api;

import static io.restassured.RestAssured.given;

public class AuthorizationApi {
    public static String getAllureTestopsSession() {
        String username = "allure8",
                password = "allure8",
                xsrfToken = "12345";

        return   given()
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
    }
}
