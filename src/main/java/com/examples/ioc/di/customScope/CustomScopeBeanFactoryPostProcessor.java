package com.examples.ioc.di.customScope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomScopeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private final String scopeName = "timeBased";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(scopeName, new TimeBasedScope());
    }
}
