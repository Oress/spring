package com.examples.ioc.di.valueAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValuePropertyBean {
    private final String valueFromProperties;
    private final String defaultValue;

    public ValuePropertyBean(
            @Value("${my.property}") String valueFromProperties,
            @Value("${nonexisting.property:defaultValue}")String defaultValue) {
        this.valueFromProperties = valueFromProperties;
        this.defaultValue = defaultValue;

        System.out.printf("ValuePropertyBean constructor: %s, %s \n", valueFromProperties, defaultValue);
    }
}
