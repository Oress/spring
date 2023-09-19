package com.examples.ioc.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class MapAutowired {
    private final Map<String, Singleton> singletons;

    @Autowired
    public MapAutowired(Map<String, Singleton> singletons) {
        this.singletons = singletons;
        // should be 3 items: Singleton, ChildSingleton1, ChildSingleton2
        System.out.printf("MapAutowired constructor %s\n", singletons);
    }
}
