package com.examples.ioc.di.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beans = beanFactory.getBeanDefinitionNames();

        System.out.printf("\nWe've got some beans: %s \n---------------------------------\n\n", String.join(", \n", beans));

//        for (String beanName : beans) {
//            beanFactory.getBeanDefinition(beanName).
//        }
    }
}
