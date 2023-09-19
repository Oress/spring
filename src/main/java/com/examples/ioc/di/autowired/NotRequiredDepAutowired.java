package com.examples.ioc.di.autowired;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotRequiredDepAutowired {
    @Autowired(required = false)
    NotRegisteredComponent notRegisteredComponent;

    @PostConstruct
    public void afterPropertiesSet() {
        System.out.printf("NotRequiredDepAutowired afterPropertiesSet called %s\n", notRegisteredComponent);
    }
}
