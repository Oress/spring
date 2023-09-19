package com.examples.ioc.di.autowired.qualifiedAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(value = "multipleCandidatesConfiguration-qualifier")
public class MultipleCandidatesConfiguration {

    @Bean("primaryConfig-qualifier")
    public SampleBean primaryConfigQualifier() {
        return new SampleBean("primaryConfig");
    }


    @Bean("secondaryConfig-qualifier")
    public SampleBean secondaryQualifier() {
        return new SampleBean("secondaryConfig");
    }
}
