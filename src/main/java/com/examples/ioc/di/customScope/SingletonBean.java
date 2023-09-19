package com.examples.ioc.di.customScope;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
@Profile("customScope")
public class SingletonBean {

    private ObjectFactory<TimeBasedBean> objectFactory;

    public SingletonBean(ObjectFactory<TimeBasedBean> objectFactory) {
        this.objectFactory = objectFactory;
    }

    @PostConstruct
    public void postConstruct() {
        ScheduledExecutorService e = Executors.newScheduledThreadPool(4);
        e.scheduleWithFixedDelay(() -> {
            TimeBasedBean bean = objectFactory.getObject();
            System.out.println("TimeBasedBean: " + bean);
        }, 0, 3, java.util.concurrent.TimeUnit.SECONDS);
    }
}
