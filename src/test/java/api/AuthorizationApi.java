package api;

import static io.restassured.RestAssured.given;

public class AuthorizationApi {
    public final static String USERNAME = "allure8",
            PASSWORD = "allure8",
            XSRF_TOKEN = "95a50912-56ff-4573-8b6f-e3e7f35460c4";

    public static String getAllureTestopsSession() {
        return given()
                .header("X-XSRF-TOKEN", XSRF_TOKEN)
                .cookie("XSRF-TOKEN", XSRF_TOKEN)
                .formParam("username", USERNAME)
                .formParam("password", PASSWORD)
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
