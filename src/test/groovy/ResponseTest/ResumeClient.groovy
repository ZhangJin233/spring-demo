package ResponseTest

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

    void getResumeDetails2(){
        given().port(9090)
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .body("name",equals("TOM"))
    }

    def getResumeDetails3(){
        given().port(9090)
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .extract()
                .response().path("contacts.phone")
    }

    def getResumeDetailHeader(){
        given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .extract()
                .response().getHeader("content-type")
    }

}
