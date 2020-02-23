package ResponseTest

import org.junit.jupiter.api.Test

/**
 *
 * @author Jane* @date 2020-02-23 4:47 PM
 *
 *
 * */
class JunitCase {
    @Test
    void testFunction() {
        ResumeClient resumeClient = new ResumeClient()
        resumeClient.getResumeDetails2()
        println "--phone information is:     " + resumeClient.getResumeDetails3()
        println "--content-type is:     " + resumeClient.getResumeDetailHeader()
    }
}
