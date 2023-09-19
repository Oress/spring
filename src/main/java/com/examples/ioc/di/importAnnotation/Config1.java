package com.examples.ioc.di.importAnnotation;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
    public Bean1 bean1() {
        return new Bean1();
    }
}
