package com.examples.ioc.di.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MetricsCollectorBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object result = bean;
        if (bean.getClass().isAnnotationPresent(Metered.class)) {
            String name = bean.getClass().getName();
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(((MethodInterceptor) (obj, method, args, proxy) -> {
                long start = System.currentTimeMillis();
                Object methodResult = method.invoke(bean, args);
                long end = System.currentTimeMillis();
                System.out.printf("%s#%s timing is: %s \n", name, method.getName(), end - start);
                return methodResult;
            }));
            result = enhancer.create();

            // JDK Dynamic Proxy only work when a class has interfaces
            /*Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        long start = System.currentTimeMillis();
                        Object result = method.invoke(bean, args);
                        long end = System.currentTimeMillis();
                        System.out.printf("{}#{} timing is: {}", name, method.getName(), end - start);
                        return result;
                    })*/;
        }
        return result;
    }
}
