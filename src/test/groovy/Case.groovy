/**
 *
 * @author Jane* @date 2020-02-12 7:27 PM
 *
 *
 **/
import groovy.json.JsonSlurper
import spock.lang.Specification
import static io.restassured.RestAssured.given
import org.junit.Assert

class Case extends Specification{

    JsonSlurper jsonSlurper = new JsonSlurper()
    //接口返回的是json字符串，jsonSlurper作用是将json字符串转换为groovy的集合对象

    def "should books response"(){
        given: ""
        when: "get books response"
        def response = given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getAllBooks")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().getBody().asString()
        then: "book's price is correct"
        def bookPrice = jsonSlurper.parseText(response).books.find{ it -> it.name == bookName }.price
        Assert.assertEquals("bookPrice: ${bookPrice} is not correct",bookPrice,price)
        where:
        bookName | price
        "三国演义" | 20
    }
}