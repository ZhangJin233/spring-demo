/**
 *
 * @author Jane* @date 2020-02-14 11:16 AM
 * 连接mysql数据库固定写法
 *
 * */
package db

import file.FileService
import groovy.sql.Sql


class DataSourceNew {
    Sql sql
    FileService fileService
    def configs
//   mysql基本配置从 config.yml 中读取
    DataSourceNew() {
        fileService = new FileService()
        configs = fileService.getConfigs('./src/test/resources/com.spring.demo/config/config.yml')
    }

    Sql getSql() {
        if (!sql) {
            def mysqlDB = [
                    driver  : 'com.mysql.jdbc.Driver',
                    url     : 'jdbc:mysql://localhost:3306/apitestdb',
                    user    : 'root',
                    password: 'root12345'
            ]

            sql = Sql.newInstance(mysqlDB.url, mysqlDB.user, mysqlDB.password, mysqlDB.driver)
            println "DB connection ready"
        }
        sql
    }
}