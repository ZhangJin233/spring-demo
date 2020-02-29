package xmlTest

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine

/**
 *
 * @author Jane* @date 2020-02-25 5:07 PM
 *
 *
 * */
class XmlTemplateService {
    VelocityEngine velocityEngine = new VelocityEngine()
    VelocityContext velocityContext = new VelocityContext()
    StringWriter stringWriter = new StringWriter()

    def getAddXmlDataBody(addXmlData) {
        velocityContext.put("addXmlData", addXmlData)
        velocityEngine.getTemplate("src/test/resources/com.spring.demo/body/template/addXmlData.vm").merge(velocityContext, stringWriter)
        stringWriter.toString()
    }
}
