package com.examples.ioc.di.importAnnotation;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
    public Bean2 bean2() {
        return new Bean2();
    }
}
