package configTest

import file.FileService

/**
 *
 * @author Jane* @date 2020-02-29 4:05 PM
 *
 *
 * */
class TestDataService {
    FileService fileService

    TestDataService() {
        fileService = new FileService()
    }

    def getUserFileData() {
        def userData = fileService.getCsvFileContent("src/test/resources/com.spring.demo/data/user.csv", ",")
        userData
    }

    def getUserDataByRole(roleName) {
        getUserFileData().find { it -> it.roleName == roleName }
    }

    def getPasswordByUserName(username) {
        Secret.decrypt("apiTestStudy", (String) getUserFileData().find { it -> it.username == username }.password)
    }
}
