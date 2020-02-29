package XmlTest

import org.junit.jupiter.api.Test

/**
 *
 * @author Jane* @date 2020-02-26 5:51 PM
 *
 *
 * */
class XmlDataService {
    XmlSlurper xmlSlurper
    XmlClient xmlClient

    XmlDataService() {
        xmlSlurper = new XmlSlurper()
        xmlClient = new XmlClient()
    }

    @Test
    void getMatchLevel() {
        def result = xmlSlurper.parseText(xmlClient.getXmlData())
        println result.View.Result.MatchLevel.text()
    }

    @Test
    void getMapView() {
        def result = xmlSlurper.parseText(xmlClient.getXmlData())
        result.View.Result.Location.MapView.TopLeft.each { it -> println it }
        println result.View.Result.Location.MapView.TopLeft.find { it -> it.Latitude == 41.88 }.Longitude
    }

    @Test
    void getAddress() {
        def result = xmlSlurper.parseText(xmlClient.getXmlData())
        println result.View.Result.Location.Address.AdditionalData.find { it -> it.@'key' == "CountryName" }.text()
    }
}
