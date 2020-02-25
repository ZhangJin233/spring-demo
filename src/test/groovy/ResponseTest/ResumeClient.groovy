package ResponseTest

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import static io.restassured.RestAssured.given

/**
 *
 * @author Jane* @date 2020-02-22 5:11 PM
 *
 *
 * */
class ResumeClient {
    def getResumeDetails() {
        def res = given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        res
    }

    void getResumeDetails2() {
        given().port(9090)
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .body("name", equals("TOM"))
    }

    def getResumeDetails3() {
        given().port(9090)
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .extract()
                .response().path("contacts.phone")
    }

    def getResumeDetailHeader() {
        given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .extract()
                .response().getHeader("content-type")
    }

    def getResumeSchemaValidate(filePath) {
        given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .then().assertThat()
        //在调用接口时通过matchsJsonSchemaInClassPath校验接口的response schema
                .body(matchesJsonSchemaInClasspath((String) filePath))
    }

    def getResume2() {
        def payLoad = given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume2")
                .then().assertThat().statusCode(200)
                .extract()
                .response()
                .path("payLoad")
        payLoad
    }

}
