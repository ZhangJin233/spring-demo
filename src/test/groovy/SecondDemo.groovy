import spock.lang.Specification

/**
 *
 * @author Jane* @date 2020-02-10 9:46 PM
 *
 *
 **/
 class SecondDemo extends Specification {

     def "should get user details by user name successfully"(){
         given: "no given"
         when: "call get user by name api"
         given().baseUri("http://localhost:9090/")
                .when()
                .pathParam("bookName",bookName)
                .get("api/getBook/{bookName}")
                .then()
                .assertThat().statusCode(200)
         then: "no then"
         where:
         bookName|placeHolder
         "TOM"|""
         "DAVE"|""
     }

 }
