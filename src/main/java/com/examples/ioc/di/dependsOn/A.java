package com.examples.ioc.di.dependsOn;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("A")
@DependsOn("B")
public class A {

    public A() {
        System.out.printf("A initialized %s \n", InitSeq.getAndIncrementSequence());
    }
}
