/**
 *
 * @author Jane* @date 2020-02-14 11:16 AM
 * 连接mysql数据库固定写法
 *
 * */
package db


import groovy.sql.Sql


class DataSource {
    Sql sql

    Sql getSql() {
        if (!sql) {
            def mysqlDB = [
                    driver  : 'com.mysql.jdbc.Driver',
                    url     : 'jdbc:mysql://localhost:3306/apitestdb?useUnicode=true&characterEncoding=UTF-8&useSSL=true&zeroDateTimeBehavior=convertToNull',
                    user    : 'root',
                    password: 'root12345'
            ]

            sql = Sql.newInstance(mysqlDB.url, mysqlDB.user, mysqlDB.password, mysqlDB.driver)
            println "DB connection ready"
        }
        sql
    }
}
