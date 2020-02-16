package file

import spock.lang.Specification

/**
 *
 * @author Jane* @date 2020-02-16 2:38 PM
 *
 *
 * */
class Case extends Specification {

    FileService fileService

    def setup() {
        fileService = new FileService()
    }

    def "should create and read txt file successfully"() {
        given: "create txt file"
        def file = fileService.createFile("./src/test/resources/com.spring.demo/data/test.txt")
        when: "write some content to the file"
        // 支持通过<<写入文件内容
        file << "name,age,address\n"
        file << "Tom,100,chengdu\n"
        then: "print file content"
        // 读取txt文件内容
        def lines = file.readLines()
        lines.each { println it }
        and: "delete file"
        file.delete()
    }

    def "should read yml file successfully"() {
        given: "no given"
        when: "get the csv data"
        def configs = fileService.getConfigs('./src/test/resources/com.spring.demo/config/config.yml')
        then: "print data"
        println configs.stable.db.url
        println configs.active
    }

    def "should read csv file successfully"() {
        given: "no given"
        when: "get the csv file data"
        def csvContent = fileService.getCsvFileContent('./src/test/resources/com.spring.demo/data/test.csv', ',')
        csvContent.each { it -> println it.name + ":" + it.age + ":" + it.address }
        //这里使用了groovy自带的处理数据集闭包each{}，打印csv文件中的所有name、age、address列内容
        //打印的值与csv文件内容一致则说明获取到了csv文件内容
        then: "no then"
    }

    def "should read json file successfully"() {
        given: ""
        when: "get json file data"
        def jsonContent = fileService.getCollectionFromJsonFile('./src/test/resources/com.spring.demo/data/test.json')
        then: "println the data"
        println jsonContent.pipelineName  //打印的值与json文件内容相同则说明正确获取到文件内容
        println jsonContent.sonar.coverage
        def stage = jsonContent.stages.find { it -> it.name == "stage2" }  //通过find方法查找json文件中stages对象下name等于“stage2”的对象
        println stage.id
        println stage.duration
    }

    def "should read xml file successfully"() {
        given: ""
        when: "get json file data"
        def xmlContent = fileService.getCollectionFromXMLFile('./src/test/resources/com.spring.demo/data/test.xml')
        then: "println the data"
        xmlContent.person.each { println it }
        println xmlContent.person.find { it -> it.name == "DAVE" }
    }
}