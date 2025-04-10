//package com.zero.learns.spring;
//
//import org.apache.catalina.connector.Connector;
//import org.apache.coyote.http2.Http2Protocol;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.awt.*;
//
///**
// * Tomcat如果需要支持 h2c，则需要指定支持h2c的本地tomcat库
// * @author ylxb2
// * @since 2024/04/23
// */
//@Configuration
//public class Http2cServletContainer {
//
//    @Value("${server.port}")
//    private int serverPort;
//
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createHttp2cContainer());
//        tomcat.addConnectorCustomizers();
//        return tomcat;
//    }
//
//    public Connector createHttp2cContainer() {
//        Connector connector = new Connector();
//        Http2Protocol http2Protocol = new Http2Protocol();
//        connector.addUpgradeProtocol(http2Protocol);
//        connector.setPort(this.serverPort + 1);
//        return connector;
//    }
//
//    public int getServerPort() {
//        return serverPort;
//    }
//
//    public void setServerPort(int serverPort) {
//        this.serverPort = serverPort;
//    }
//}
