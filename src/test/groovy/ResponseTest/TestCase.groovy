package ResponseTest

import spock.lang.Specification
import static org.hamcrest.MatcherAssert.assertThat
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath

/**
 *
 * @author Jane* @date 2020-02-22 5:24 PM
 *
 *
 * */
class TestCase extends Specification {
    ResumeService resumeService
    ResumeClient resumeClient

    def setup() {
        resumeClient = new ResumeClient()
        resumeService = new ResumeService()
    }

    def "get person from different country"() {
        given: "no given"
        when: "call the get resume api"
        def res = resumeClient.getResumeDetails()
        then: "println out the person name from different country"
        println resumeService.getPersonByCountry(res, country)
        where:
        country | placeHolder
        "China" | ""
        "USA"   | ""
    }

    def "get contact from resume"() {
        given: "no given"
        when: "call the get resume api"
        def res = resumeClient.getResumeDetails()
        then: "println out contacts info"
        println resumeService.getContactPhone(res)
    }

    def "println language skill if person with it"() {
        given: "no given"
        when: "call the get resume api"
        def res = resumeClient.getResumeDetails()
        then: "println out contacts info"
        println resumeService.printIfPersonWIthSpecialSkill(res, language)
        where:
        language | placeHolder
        "Java"   | ""
    }

    def "get all working experience"() {
        given: "no given"
        when: "call the get resume api"
        def res = resumeClient.getResumeDetails()
        then: "println out contacts info"
        println resumeService.printWorkingDetails(res)

    }

    def "call the api"() {
        given: "no given"
        when: "call the get resume api"
        resumeClient.getResumeSchemaValidate(filePath)
        then: "no then"
        where:
        filePath                                      | placeHolder
        "com.spring.demo/schema/getResumeSchema.json" | ""
    }

    def "validate schema of getResume2 api"() {
        given: "no given"
        when: "call the get resume2 api"
        def payLoad = resumeClient.getResume2()
        then: "check the schema"
        assertThat(payLoad, matchesJsonSchemaInClasspath(filePath))
        where:
        filePath                                                            | placeHolder
        "com.spring.demo/schema/getResumeSchema2.json" | ""
    }
}
