package test

import file.FileService
import spock.lang.Specification
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author Jane* @date 2020-02-20 9:51 PM
 *
 *
 * */
class RequestBodyCase extends Specification {
    FileService fileService
    UserClient userClient

    def setup() {
        fileService = new FileService()
        userClient = new UserClient()
    }

    def "should add user successfully"() {
        given: "no given"

        when: "call the add user api"

        def file = fileService.createFile("./src/test/resources/com.spring.demo/body/addUser.json")

        then: "get the correct response"
        assertEquals(userClient.addUserWithFile(file), "add user successfully")
    }

    def "should add user with only inputting main contact successfully"() {
        given: "generate request body"
        def body = new AddUserBody()
                .addMainContact(city, street, phone)
                .generateBody()
        when: "call add user api"
        def response = userClient.addUserWithString(body)
        then: "should get correct response"
        assertEquals("assert add api response correct", response, "add user successfully")
        where:
        city      | street          | phone
        "chengdu" | "qingyi-street" | 11223344556
    }

    def "should add user with inputting main and backup contact successfully"() {
        given: "generate request body"
        def body = new AddUserBody()
                .addMainContact(mainCity, mainStreet, mainPhone)
                .addMainContact(backupCity, backupStreet, backPhone)
                .generateBody()
        when: "call add user api"
        def response = userClient.addUserWithString(body)
        then: "should get correct response"
        assertEquals("assert add user api response correct", response, "add user successfullly")
        where:
        mainCity  | mainStreet   | mainPhone   | backupCity | backupStreet | backPhone
        "chengdu" | "one-street" | 11223344556 | "beijing"  | "two-street" | 00112233445
    }

    def "should add user with inputting contacts and background successfully"() {
        given: "generate request body"
        def body = new AddUserBody()
                .addMainContact(mainCity, mainStreet, mainPhone)
                .addBackupContact(backupCity, backupStreet, backupPhone)
                .addBackGround(degree, school, date)
                .generateBody()
        when: "call add user api"
        def response = userClient.addUserWithString(body)
        then: "should get correct response"
        assertEquals("assert add user api response correct", response, "add user successfully")
        where:
        mainCity  | mainStreet   | mainPhone   | backupCity | backupStreet | backupPhone | degree   | school    | date
        "chengdu" | "one-street" | 11223344556 | "beijing"  | "two-street" | 00112233445 | "doctor" | "qinghua" | "2019-07"
    }
}
