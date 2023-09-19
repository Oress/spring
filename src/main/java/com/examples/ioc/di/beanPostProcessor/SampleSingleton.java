package com.examples.ioc.di.beanPostProcessor;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// We need to call methods 'from outside' because the proxy functionality would not be called otherwise
@Component("SampleSingletonBPP")
@Profile("beanPostProcessor")
public class SampleSingleton {

    @Autowired
    private SampleClass sampleClass;

    @PostConstruct
    public void method1() {
        ScheduledExecutorService e = Executors.newScheduledThreadPool(4);
        e.scheduleWithFixedDelay(() -> {
            sampleClass.forLoopMethod();
            sampleClass.sleepMethod();
        }, 2, 3, java.util.concurrent.TimeUnit.SECONDS);
    }
}
