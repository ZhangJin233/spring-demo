package com.spring.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class DemoApplication {

    private static final int PORT = 9090;

    private static final String LOCALHOST= "localhost";
    //定义mapping文件目录
    private static final String MOCK_DIR="mock";

	public static void main(String[] args) {
	    final WireMockConfiguration config = wireMockConfig()
                                    .port(PORT)
                                    .usingFilesUnderClasspath(MOCK_DIR);
	    final WireMockServer wireMockServer = new WireMockServer(config);
	    wireMockServer.start();
	    WireMock.configureFor(LOCALHOST,PORT);
	}
}
