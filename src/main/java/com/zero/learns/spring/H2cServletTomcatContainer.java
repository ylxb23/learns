package com.zero.learns.spring;

import org.eclipse.jetty.http2.server.HTTP2CServerConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.ServerConnector;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 *
 * 默认情况下：
 * o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
 *
 * 配置了h2c之后：
 * o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port(s) 8880 (http/1.1, h2c) with context path '/'
 *
 * @author ylxb2
 * @since 2024/04/23
 */
@Component
public class H2cServletTomcatContainer implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {

    @Override
    public void customize(JettyServletWebServerFactory factory) {
        JettyServerCustomizer customizer = s -> {
            for(Connector c : s.getConnectors()) {
                if(c instanceof ServerConnector sc) {
                    HTTP2CServerConnectionFactory h2cFactory = new HTTP2CServerConnectionFactory(new HttpConfiguration());
                    sc.addConnectionFactory(h2cFactory);
                }
            }
        };
        factory.addServerCustomizers(customizer);
    }
}
