package test

import static io.restassured.RestAssured.given

/**
 *
 * @author Jane* @date 2020-02-20 9:40 PM
 *
 *
 * */
class UserClient {
    def addUserWithFile(File file) {
        def res = given().port(9090)
                .when()
                .body(file)
                .post("/api/addUserDetails")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        res
    }

    def addUserWithString(String body) {
        def res = given().baseUri("http://localhost:9090").log().all()
                .when()
                .body(body)
                .post("/api/addUserDetails")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        res
    }
}
