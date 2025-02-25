package com.zero.learns.spring;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * spring.App
 * 默认启动的情况下，启动的web容器是tomcat，仅支持 http协议：o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
 *
 * Now:
 * o.s.b.w.e.j.JettyWebServer.start#172: Jetty started on port(s) 8880 (http/1.1, h2c) with context path '/'
 * @author ylxb2
 * @since 2024/3/1 17:01
 */
@SpringBootApplication(scanBasePackages = {"com/zero/learns/spring", "com/zero/learns/beans"})
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        logger.info("beans: {}", Lists.asList("", context.getBeanDefinitionNames()));
    }
}
