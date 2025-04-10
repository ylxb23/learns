package com.zero.learns.spring;

import com.zero.learns.logs.LogTraceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zero
 * @since 2025/2/13 17:24
 */
@Configuration
public class TraceConfigurationAdapter implements WebMvcConfigurer {

    @Bean
    public LogTraceInterceptor logTraceInterceptor() {
        return new LogTraceInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(logTraceInterceptor());
    }
}
