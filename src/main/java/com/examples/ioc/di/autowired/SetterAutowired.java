package com.examples.ioc.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterAutowired {
    private Singleton singleton;

    @Autowired
    public void setSingleton(Singleton singleton) {
        this.singleton = singleton;
    }
}
