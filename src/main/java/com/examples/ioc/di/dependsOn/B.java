package com.examples.ioc.di.dependsOn;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("B")
@DependsOn("C")
public class B {
    public B() {
        System.out.printf("B initialized %s \n", InitSeq.getAndIncrementSequence());
    }
}
