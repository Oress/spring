package com.examples.ioc.di.lookup;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// incorrect way to implement interaction between bean with different scopes
// because now the Spring specific code is bound to our business code
@Component
public class SingletonContextAware implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void postConstruct() {
        PrototypeBean p1 = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean p2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println("SingletonContextAware p1 == p2: " + (p1 == p2));
    }

}
