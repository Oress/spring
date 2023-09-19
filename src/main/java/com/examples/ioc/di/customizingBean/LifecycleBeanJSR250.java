package com.examples.ioc.di.customizingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

// pretty much the same thing as a LifecycleBean but more modern approach
@Component
public class LifecycleBeanJSR250 {
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("LifecycleBeanJSR250#destroy() method called");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleBeanJSR250#afterPropertiesSet() method called");
    }
}
