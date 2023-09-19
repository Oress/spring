package com.examples.ioc.mvc.customExceptionHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class ExceptionConfig {

    @Bean
    public HandlerExceptionResolver customExceptionHandler() {
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        customExceptionHandler.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return customExceptionHandler;
    }
}
