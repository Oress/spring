package com.examples.ioc.di.customizingBean;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

// ?????
// Not exactly sure how does it work
@Component
public class LifecycleBean2 implements Lifecycle {
    @Override
    public void start() {
        System.out.println("LifecycleBean2#start() method called");
    }

    @Override
    public void stop() {
        System.out.println("LifecycleBean2#stop() method called");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
