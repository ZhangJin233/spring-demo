package configTest

import file.FileService

/**
 *
 * @author Jane* @date 2020-02-29 12:24 PM
 *
 *
 * */
class ConfigParser {
    FileService fileService

    ConfigParser() {
        fileService = new FileService()
    }

    def getConfigs(String configFilePath) {
        def configs = fileService.getConfigs(configFilePath)
        def sysEnv = System.getenv("ACTIVE_ENV")
        def active = sysEnv ? sysEnv : configs.active
        configs.putAll(configs.get(active))
        configs
    }

    def getGlobalConfig() {
        def configs
        configs = getConfigs("src/test/resources/com.spring.demo/config/config.yml")
        configs
    }
}
