import spock.lang.Specification
import static io.restassured.RestAssured.given

/**
 *
 * @author Jane* @date 2020-02-12 2:13 PM
 *
 *
 * */
class ThirdDemo extends Specification {
    def "should call get user by name and age api successfully"() {
        given: "no given"
        when: "call mock api api"
        given().port(9090).log().all()
                .queryParam("name", "sanguo")
                .queryParam("price", 18)
                .when()
                .get("api/getBookByPathPatter/test")
                .then()
                .assertThat().statusCode(200)
        then: "no then"
    }
}