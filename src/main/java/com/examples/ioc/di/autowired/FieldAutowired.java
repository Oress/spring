package com.examples.ioc.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldAutowired {
    @Autowired
    private Singleton singleton;
}
