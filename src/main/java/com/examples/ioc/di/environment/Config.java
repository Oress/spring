package com.examples.ioc.di.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    @Profile("dev")
    public BeanDev beanDev() {
        System.out.println("Enabling dev profile");
        return new BeanDev();
    }

    @Bean
    @Profile("prod")
    public BeanProd beanProd() {
        System.out.println("Enabling prod profile");
        return new BeanProd();
    }
}
