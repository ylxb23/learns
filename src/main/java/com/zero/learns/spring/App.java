package com.zero.learns.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring.App
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
