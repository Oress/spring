package com.examples.ioc.di.lookup;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

// correct way to implement interaction between bean with different scopes using @Lookup annotation

@Component
public class SingletonLookup {
    @Lookup
    public PrototypeBean getPrototypeBean() {
        throw new UnsupportedOperationException("This method should be overridden by Spring proxy.");
    }

    @PostConstruct
    public void postConstruct() {
        PrototypeBean p1 = getPrototypeBean();
        PrototypeBean p2 = getPrototypeBean();
        System.out.println("SingletonLookup p1 == p2: " + (p1 == p2));
    }
}
