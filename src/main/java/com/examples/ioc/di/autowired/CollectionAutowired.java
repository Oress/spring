package com.examples.ioc.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CollectionAutowired {
    private final Set<Singleton> singletons;

    @Autowired
    public CollectionAutowired(Set<Singleton> singletons) {
        this.singletons = singletons;
        // should be 3 items: Singleton, ChildSingleton1, ChildSingleton2
        System.out.printf("CollectionAutowired constructor %s\n", singletons);
    }
}
