package ResponseTest

import groovy.json.JsonSlurper

/**
 *
 * @author Jane* @date 2020-02-22 5:16 PM
 *
 *
 * */
class ResumeService {
    JsonSlurper jsonSlurper

    ResumeService() {
        jsonSlurper = new JsonSlurper()
    }

    def getPersonByCountry(String res, country) {

        //将String类型的json字符串转换为数据对象，转换为数据对象后才能轻松获取对应的属性值
        def resumeDetails = jsonSlurper.parseText(res)

        //获取接口response body中的contry信息，如果与传入的country一致则返回该值，否则返回“no person”
        resumeDetails.birthPlace.country == country ? resumeDetails.name : "no person"
    }

    def getContactPhone(String res){
        def resumeDetails = jsonSlurper.parseText(res)
        resumeDetails.contacts.size() > 0 ? resumeDetails.contacts[0].phone : "no contact"
    }

    void printIfPersonWIthSpecialSkill(String res,language){
        def resumeDetails = jsonSlurper.parseText(res)
        if(resumeDetails.skills.tech.size() > 0){
            def programmingSkill = resumeDetails.skills.tech.find{it -> it.language == language}
            println "--programingSkill:${programmingSkill.language}--level:${programmingSkill.level}"
        }
    }

    void printWorkingDetails(String res){
        def resumeDetails = jsonSlurper.parseText(res)
        if(resumeDetails.working.workingProject.size() > 0){
            resumeDetails.working.workingProject.each{it ->
                println "--projectName:${it.projectName}--jobTitle:${it.jobTitle}--responsibility:${it.responsibility}"
            }
        }
    }
}
