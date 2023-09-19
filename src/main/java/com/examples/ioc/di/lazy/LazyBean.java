package com.examples.ioc.di.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // With this annotation you should not see the "LazyBean initialized" in the console, since there are no usages of this bean.
public class LazyBean {
    public LazyBean() {
        System.out.println("LazyBean initialized");
    }
}
