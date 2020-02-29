package xmlTest

import spock.lang.Specification
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Jane* @date 2020-02-25 5:28 PM
 *
 *
 * */
class AddXmlDataCase extends Specification {
    XmlTemplateService xmlTemplateService
    XmlClient xmlClient

    def setup() {
        xmlTemplateService = new XmlTemplateService()
        xmlClient = new XmlClient()
    }

    def "should add xml data successfully"() {
        given: "generate add xml data api request body"
        def reqBody = new AddXmlDataBody()
                .setBookName("bookName-sanguo")
                .setPrice(20)
                .setAuthor("luoguanzhong")
                .getAddXmlDataBody()

        when: "call add xml data api"
        def res = xmlClient.addXmlData(reqBody)
        then: "should get correct response"
        assertEquals(res, "add xml data successfully")
    }

    def "should add xml data with invalid bookName failed"() {
        given: "generate add xml data api request body"
        def reqBody = new AddXmlDataBody()
                .setBookName("sanguo")      //mock接口的时候要求request body中bookName字段必须包含“bookName”字符串，这里设置的书名不正确，调用接口应该会失败
                .setPrice(20)
                .setAuthor("luoguanzhong")
                .getAddXmlDataBody()

        when: "call add xml data api"
        xmlClient.addXmlData(reqBody, 404)
        then: "no then"
    }


}
