package db

import static org.junit.jupiter.api.Assertions.assertEquals;
import spock.lang.Specification

/**
 *
 * @author Jane* @date 2020-02-14 11:48 AM
 *
 *
 * */


class Case extends Specification {
    DataRepository dataRepository

    void setup() {
        dataRepository = new DataRepository()
    }

    def "should get user info successfully"() {
        given: "no given"
        when: "query user table to get info"
        def userInfo = dataRepository.getUserInfo()
        then: "should get user info"
        userInfo.each { it -> println it.id + ":" + it.username + ":" + it.age + ":" + it.create_date }  //打印从数据库获取到的所有user信息
    }

    def "should get user address successfully"() {
        given: "no given"
        when: "query user and address table"
        def addressInfo = dataRepository.getAddressByUserName(userName)
        then: "shoule get correct user address info"
        assertEquals(addressInfo.address, address)  //校验从数据库获取的数据是否正确
        where:
        userName | address
        "TOM"    | "chengdu"
        "DONE"   | "beijing"
        "ECHO"   | "shanghai"
        "MARY"   | "hangzhou"
    }

    def "should add user successfully"() {
        given: "no given"
        when: "add user"
        dataRepository.addUser(userName, age)
        then: "should get added user successfully"
        assertEquals(dataRepository.getUser(userName).username, userName)  //只有成功添加了“Dave”这个user，校验才会成功
        where:
        userName | age
        "Dave"   | 88
    }

    def "should update address successfully"() {
        given: "no given"
        when: "update user's address"
        dataRepository.updateAddress(userName, age)  //修改user表信息
        then: "should update address successfully"
        assertEquals(dataRepository.getUser(userName).age, age)  //校验修改后的user的age是否正确
        where:
        userName | age
        "MARY"   | 55
    }
}