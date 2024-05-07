package com.zero.learns.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring.App
 * 默认启动的情况下，启动的web容器是tomcat，仅支持 http协议：o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
 *
 * @author ylxb2
 * @since 2024/3/1 17:01
 */
@SpringBootApplication(scanBasePackages = {"com/zero/learns/spring"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
