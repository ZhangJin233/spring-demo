package configTest

import org.junit.jupiter.api.Test

import static io.restassured.RestAssured.given

/**
 *
 * @author Jane* @date 2020-02-29 1:56 PM
 *
 *
 * */
class GetDataClient {
    ConfigParser configParser
    def configs

    GetDataClient() {
        configParser = new ConfigParser()
        configs = configParser.getGlobalConfig()
    }

    void getData() {
        def res = given().baseUri((String) configs.mockServerUrl)
                .auth().preemptive().basic("apiUsername", "apiPassword")
                .when()
                .get("/api/getData")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        println res
    }

    @Test()
    void callGetData() {
        getData()
    }
}
