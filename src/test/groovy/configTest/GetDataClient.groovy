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
    TestDataService testDataService
    def users
    def configs

    GetDataClient() {
        configParser = new ConfigParser()
        testDataService = new TestDataService()
        users = testDataService.getUserDataByRole("ForGetDataApi")
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

    void getDataWithCsvUser() {
        def res = given().baseUri((String) configs.mockServerUrl)
                .auth().preemptive().basic(users.username, users.password)
                .when()
                .get("/api/getData")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        println res
    }

    void getDataWithEncryptPassword() {
        def res = given().baseUri((String) configs.mockServerUrl)
                .auth().preemptive().basic(users.username, userTestData.getPasswordByUserName(users.username))
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

    @Test()
    void callGetDataWithCsvUser() {
        getDataWithCsvUser()
    }

    @Test()
    void callGetDataWithEncryptPassword() {
        getDataWithEncryptPassword()
    }
}
