/**
 *
 * @author Jane* @date 2020-02-12 2:30 PM
 *
 *
 * */
import spock.lang.Specification
import static io.restassured.RestAssured.given


class FourDemo extends Specification {
    def "should add user successfully"() {
        given: "no given"
        def body = "{\"name\": {\"mainName\": \"zhangshang\",\"alias\": \"zhangshangalias\"},\"age\":123}"
        when: "call get user by name api"
        given().log().all()
                .port(9090)
                .auth().preemptive().basic("root", "root123")
                .header("Content-Type", "application/json")
                .cookie("session", "123456")
                .body(body)
                .when()
                .post("/api/addUser")
                .then()
                .log().all()
                .assertThat().statusCode(200)
        then: "no then"
    }
}