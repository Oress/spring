package com.examples.ioc.spel;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleSpelBean {

    @Value("#{systemProperties['user.home']}")
    private String propValue;

    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String envValue;

    @PostConstruct
    private void postConstruct() {
        System.out.printf("SimpleSpelBean value from field Property %s \n", propValue);
        System.out.printf("SimpleSpelBean value from field Environment %s \n", envValue);
    }
}
