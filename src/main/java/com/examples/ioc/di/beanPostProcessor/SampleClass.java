package com.examples.ioc.di.beanPostProcessor;

import com.examples.ioc.di.customScope.TimeBasedBean;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Metered
@Component
public class SampleClass {
    int a = 0;

    public void forLoopMethod() {
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 1000000; j++) {
                a = i + j;
            }
        }
    }

    public void sleepMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
