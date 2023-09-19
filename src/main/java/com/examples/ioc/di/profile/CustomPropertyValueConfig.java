package com.examples.ioc.di.profile;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPropertyValueConfig {

    @Value("${prop1}")
    private String myCustomProp;

    @PostConstruct
    public void postConstruct() {
        System.out.printf("Value of my property is : %s \n", myCustomProp);
    }
}
