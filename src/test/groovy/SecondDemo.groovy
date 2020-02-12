import spock.lang.Specification
import static io.restassured.RestAssured.given

/**
 *
 * @author Jane* @date 2020-02-10 9:46 PM
 *
 *
 * */
class SecondDemo extends Specification {

    def "should get user details by user name successfully"() {
        given: "no given"
        when: "call get user by name api"
        given().port(9090)
                .when()
                .pathParam("bookName", bookName)
                .get("api/getBook/{bookName}")
                .then().log().all()
                .assertThat().statusCode(200)
        then: "no then"
        where:
        bookName | placeHolder
        "tom"    | ""
        "dave"   | ""
    }
}
