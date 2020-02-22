package ResponseTest

import spock.lang.Specification

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
}
