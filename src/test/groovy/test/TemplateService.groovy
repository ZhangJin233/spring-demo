package test

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine

/**
 *
 * @author Jane* @date 2020-02-21 12:03 AM
 *
 *
 * */
class TemplateService {
    VelocityEngine velocityEngine = new VelocityEngine()
    VelocityContext velocityContext = new VelocityContext()
    StringWriter stringWriter = new StringWriter()

    def getAddUserRequestBody(addUserBody) {
        velocityContext.put("addUserBody", addUserBody)
        velocityEngine.getTemplate("src/test/resources/com.spring.demo/body/template/addUserTemplate.json").merge(velocityContext, stringWriter)
        stringWriter.toString()
//        上面三行属于固定写法，目的是把数据对象addUserBody和模版文件进行merge
//        如果对这部分内容不理解，不用急，待后续查看了接口调用时构造出来的request body后再反过来看velocity这个工具，理解起来就会简单很多
    }
}
