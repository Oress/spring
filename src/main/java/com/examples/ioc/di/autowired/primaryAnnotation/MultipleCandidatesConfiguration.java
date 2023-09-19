package com.examples.ioc.di.autowired.primaryAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultipleCandidatesConfiguration {

    @Bean
    @Primary // If we comment out this line, we will get an exception
    public SampleBean primaryConfig() {
        return new SampleBean("primaryConfig");
    }


    @Bean
    public SampleBean secondary() {
        return new SampleBean("secondaryConfig");
    }
}
