package XmlTest

/**
 *
 * @author Jane* @date 2020-02-25 5:24 PM
 *
 *
 * */
class XmlClient {
    def addXmlData(reqBody, expectCode = 200) {

        def res = given().baseUri("http://localhost:9090")
                .header("Content-Type", "application/xml;charset=utf-8")
                .body(reqBody)
                .when()
                .post("/api/addXmlData")
                .then().assertThat().statusCode(expectCode)
                .extract().response().getBody().asString()
        res
    }
}
