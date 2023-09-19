package com.examples.ioc.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary
// if the target bean defines only one constructor to begin with
@Component
public class ConstructorAutowired {
    private final Singleton singleton;

    @Autowired
    public ConstructorAutowired(Singleton singleton) {
        this.singleton = singleton;
    }
}
