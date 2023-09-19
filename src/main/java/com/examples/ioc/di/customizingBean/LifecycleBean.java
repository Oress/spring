package com.examples.ioc.di.customizingBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleBean#destroy() method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleBean#afterPropertiesSet() method called");
    }
}
